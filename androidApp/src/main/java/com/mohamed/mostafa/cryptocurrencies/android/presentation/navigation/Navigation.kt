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
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.detail.CryptoDetailScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.detail.CryptoDetailViewModel
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.CryptosScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.CryptosViewModel
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.EventsScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.EventsViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val bottomBarScreens = listOf(
        BottomBarScreen.Cryptos,
        BottomBarScreen.Events,
        BottomBarScreen.Settings,
    )
    Scaffold(
        bottomBar = {
            if (navController.currentDestination?.route != Screen.CryptoDetail.route) {
                MyBottomBar(navController = navController, screens = bottomBarScreens)
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
                    onTriggerAction = viewModel::onTriggerIntent,
                    onItemClick = { crypto ->
                        navController.navigate("${Screen.CryptoDetail.route}/${crypto.id}")
                    }
                )
            }

            composable(BottomBarScreen.Events.route) { navBackStackEntry ->
                val viewModel = hiltViewModel<EventsViewModel>()
                EventsScreen(
                    state = viewModel.state.value,
                    onTriggerAction = viewModel::onTriggerAction,
                )
            }

            composable(
                route = Screen.CryptoDetail.route + "/{cryptoId}",
                arguments = listOf(navArgument("cryptoId") {
                    type = NavType.StringType
                }),
            ) { navBackStackEntry ->
                val viewModel = hiltViewModel<CryptoDetailViewModel>()
                CryptoDetailScreen(viewModel.state.value)
            }
        }
    }
}

@Composable
fun MyBottomBar(
    navController: NavController,
    screens: List<BottomBarScreen>,
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screens.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(stringResource(screen.title)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    if (screen.route == BottomBarScreen.Cryptos.route) {
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