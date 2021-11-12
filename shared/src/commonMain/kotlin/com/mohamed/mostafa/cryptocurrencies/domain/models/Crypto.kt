package com.mohamed.mostafa.cryptocurrencies.domain.models

data class Crypto(
    val id: String? = null,
    val name: String? = null,
    val image: String? = null,
    val currentPrice: Double? = null,
    val marketCapRank: Int? = null,
)