package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list

import androidx.compose.runtime.Composable
import com.mohamed.mostafa.cryptocurrencies.android.base.components.DefaultScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.components.CryptosList
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos.CryptosIntent
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos.CryptosState

@Composable
fun CryptosScreen(
    state: CryptosState,
    onTriggerIntent: (CryptosIntent) -> Unit,
    onItemClick: (Crypto) -> Unit,
) {

    DefaultScreen(
        isLoading = state.isLoading,
        errorMessage = if (state.page == 1) state.errorMessage else null,
    ) {
        CryptosList(
            isLoadingMore = state.isLoadingMore,
            items = state.cryptos,
            page = state.page,
            errorMessage = if (state.page > 1 && state.errorMessage != null) state.errorMessage else null,
            getNextPage = {
                onTriggerIntent(CryptosIntent.GetNextPage)
            },
            onRetryClick = {
                onTriggerIntent(CryptosIntent.GetCryptos)
            },
            onItemClick = onItemClick,
        )
    }
}