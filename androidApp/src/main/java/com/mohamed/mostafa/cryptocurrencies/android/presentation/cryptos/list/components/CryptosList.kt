package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.components


import androidx.compose.runtime.Composable
import com.mohamed.mostafa.cryptocurrencies.android.base.components.PaginatedLazyList
import com.mohamed.mostafa.cryptocurrencies.android.presentation.components.CryptoListItem
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

@Composable
fun CryptosList(
    isLoadingMore: Boolean,
    items: List<Crypto>,
    page: Int,
    getNextPage: () -> Unit,
    onRetryClick: () -> Unit,
    onFavoriteClick: (Crypto) -> Unit,
    onItemClick: (Crypto) -> Unit,
    errorMessage: String? = null,
) {
    PaginatedLazyList(
        items = items,
        errorMessage = errorMessage,
        isLoadingMore = isLoadingMore,
        currentPage = page,
        getNextPage = getNextPage,
        onRetryClick = onRetryClick,
        itemContent = { crypto ->
            CryptoListItem(crypto, onItemClick, onFavoriteClick)
        }
    )
}

