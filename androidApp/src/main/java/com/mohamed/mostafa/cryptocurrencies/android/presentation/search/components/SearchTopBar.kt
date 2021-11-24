package com.mohamed.mostafa.cryptocurrencies.android.presentation.search.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*


@Composable
fun SearchTopBar(
    onSortByPriceClick: () -> Unit,
    onSortByNameClick: () -> Unit,
) {

    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text("Search") },
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }
            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(onClick = { onSortByPriceClick() }) {
                    Text("Sort By Price", style = MaterialTheme.typography.body1)
                }
                DropdownMenuItem(onClick = { onSortByNameClick() }) {
                    Text("Sort By Name", style = MaterialTheme.typography.body1)
                }
            }
        }
    )
}