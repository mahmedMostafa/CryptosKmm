package com.mohamed.mostafa.cryptocurrencies.presentation.cryptos

import com.mohamed.mostafa.cryptocurrencies.data.remote.models.CryptoDto
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.domain.models.PaginatedList

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

