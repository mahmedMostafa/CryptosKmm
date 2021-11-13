package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CryptoDetailDto(

    @SerialName("id")
    val id: String? = null,

    @SerialName("description")
    val description: Description? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("symbol")
    val symbol: String? = null,

    @SerialName("current_price")
    val currentPrice: CurrentPrice? = null,

    @SerialName("market_cap_rank")
    val marketCapRank: Int? = null,

    @SerialName("market_cap")
    val marketCap: MarketCap? = null,

    @SerialName("total_volume")
    val totalVolume: Long? = null
)

@Serializable
data class Description(

    @SerialName("en")
    val en: String? = null
)

@Serializable
data class CurrentPrice(

    @SerialName("usd")
    val usd: Double? = null
)

@Serializable
data class MarketCap(

    @SerialName("usd")
    val usd: Long? = null,
)

