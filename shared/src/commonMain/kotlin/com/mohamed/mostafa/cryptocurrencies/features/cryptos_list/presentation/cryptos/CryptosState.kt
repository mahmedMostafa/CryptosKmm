package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos

import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

data class CryptosState(
    var cryptos: List<Crypto> = emptyList(),
    val page: Int = 1,
    val hasReachedMax: Boolean = false,
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val errorMessage: String? = null,
) {
    constructor() : this(
        cryptos = emptyList(),
        page = 1,
        hasReachedMax = false,
        isLoading = false,
        isLoadingMore = false,
        errorMessage = null,
    )
}

