package com.mohamed.mostafa.cryptocurrencies.android.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.mohamed.mostafa.cryptocurrencies.android.presentation.components.CryptoListItem
import com.mohamed.mostafa.cryptocurrencies.android.presentation.search.components.SearchTextField
import com.mohamed.mostafa.cryptocurrencies.android.presentation.search.components.SearchTopBar
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto


@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    query: String,
    cryptos: List<Crypto>,
    onDoneClick: () -> Unit,
    onSearchByPriceClick: () -> Unit,
    onSearchByNameClick: () -> Unit,
    onValueChange: (String) -> Unit,
    onCryptoItemClick: (Crypto) -> Unit,
) {
    Scaffold(
        topBar = {
            SearchTopBar(onSearchByPriceClick, onSearchByNameClick)
        }
    ) {
        Column {
            SearchTextField(query = query, onValueChange = onValueChange, onDoneClick = onDoneClick)
            LazyColumn {
                items(cryptos) { crypto ->
                    CryptoListItem(
                        item = crypto,
                        onItemClick = onCryptoItemClick,
                        onFavoriteClick = {}
                    )
                }
            }
        }
    }
}