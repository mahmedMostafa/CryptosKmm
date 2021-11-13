package com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.presentation

import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

data class CryptoDetailState(
    val crypto: Crypto? = null,
    val isLoading: Boolean,
    val errorMessage: String? = null,
) {

    constructor() : this(
        crypto = null,
        isLoading = false,
        errorMessage = null,
    )
}
