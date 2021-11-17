package com.mohamed.mostafa.cryptocurrencies.shared.domain.models

data class Crypto(
    val id: String? = null,
    val name: String? = null,
    val symbol: String? = null,
    val image: String? = null,
    val description: String? = null,
    val currentPrice: Double? = null,
    val marketCap: Long? = null,
    val marketCapRank: Int? = null,
    val priceState: PriceState? = null,
    var isFavorite: Boolean? = false,
)

enum class PriceState {
    DID_GO_DOWN,
    DID_GO_UP,
    STILL,
}