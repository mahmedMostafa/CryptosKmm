package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.mohamed.mostafa.cryptocurrencies.android.base.components.DefaultScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.components.CryptosList
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos.CryptosActions
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos.CryptosState

@Composable
fun CryptosScreen(
    state: CryptosState,
    onTriggerAction: (CryptosActions) -> Unit,
    onItemClick: (Crypto) -> Unit,
    onSearchClick: () -> Unit,
) {

    DefaultScreen(
        isLoading = state.isLoading,
        errorMessage = if (state.page == 1) state.errorMessage else null,
        topBar = {
            TopAppBar(
                title = { Text("Cryptos") },
                actions = {
                    IconButton(onClick = { onSearchClick() }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                }
            )
        }
    ) {
        CryptosList(
            isLoadingMore = state.isLoadingMore,
            items = state.cryptos,
            page = state.page,
            errorMessage = if (state.page > 1 && state.errorMessage != null) state.errorMessage else null,
            getNextPage = {
                onTriggerAction(CryptosActions.GetNextPage)
            },
            onRetryClick = {
                onTriggerAction(CryptosActions.GetCryptos)
            },
            onFavoriteClick = {
                onTriggerAction(CryptosActions.AddOrRemoveFromFavorites(it.id ?: ""))
            },
            onItemClick = onItemClick,
        )
    }
}