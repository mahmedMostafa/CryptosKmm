package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models

data class Crypto(
    val id: String? = null,
    val name: String? = null,
    val image: String? = null,
    val description: String? = null,
    val currentPrice: Double? = null,
    val marketCap: Long? = null,
    val marketCapRank: Int? = null,
)