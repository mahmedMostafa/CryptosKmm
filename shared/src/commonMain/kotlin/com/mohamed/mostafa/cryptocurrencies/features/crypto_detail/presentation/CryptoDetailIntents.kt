package com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.presentation

sealed class CryptoDetailIntents {

    data class GetCryptoDetail(val id: String) : CryptoDetailIntents()
}
