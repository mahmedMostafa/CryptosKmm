package com.mohamed.mostafa.cryptocurrencies.android.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.CryptosScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.CryptosViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val screens = listOf(
        BottomBarScreen.Cryptos,
        BottomBarScreen.Events,
        BottomBarScreen.Settings,
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(stringResource(screen.title)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            if (screen.route == "cryptos") {
                                navController.popBackStack(
                                    destinationId = navController.graph.findStartDestination().id,
                                    inclusive = false
                                )
                            } else {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = BottomBarScreen.Cryptos.route,
            Modifier.padding(innerPadding)
        ) {
            composable(BottomBarScreen.Cryptos.route) { navBackStackEntry ->
                val viewModel = hiltViewModel<CryptosViewModel>()
                CryptosScreen(
                    state = viewModel.state.value,
                    onTriggerIntent = viewModel::onTriggerIntent
                )
            }
            composable(BottomBarScreen.Events.route) { navBackStackEntry ->

            }
        }
    }
}