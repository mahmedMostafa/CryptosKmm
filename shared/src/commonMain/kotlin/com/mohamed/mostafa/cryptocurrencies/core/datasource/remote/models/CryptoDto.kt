package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
data class CryptoDto(

    @SerialName("ath")
    val ath: Double? = null,

    @SerialName("ath_change_percentage")
    val athChangePercentage: Double? = null,

    @SerialName("ath_date")
    val athDate: String? = null,

    @SerialName("atl")
    val atl: Double? = null,

    @SerialName("atl_change_percentage")
    val atlChangePercentage: Double? = null,

    @SerialName("atl_date")
    val atlDate: String? = null,

    @SerialName("circulating_supply")
    val circulatingSupply: Double? = null,

    @SerialName("current_price")
    val currentPrice: Double? = null,

    @SerialName("high_24h")
    val high24h: Double? = null,

    @SerialName("id")
    val id: String? = null,

    @SerialName("image")
    val image: String? = null,

    @SerialName("last_updated")
    val lastUpdated: String? = null,

    @SerialName("low_24h")
    val low24h: Double? = null,

    @SerialName("market_cap")
    val marketCap: Long? = null,

    @SerialName("market_cap_change_24h")
    val marketCapChange24h: Double? = null,

    @SerialName("market_cap_change_percentage_24h")
    val marketCapChangePercentage24h: Double? = null,

    @SerialName("market_cap_rank")
    val marketCapRank: Int? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("price_change_24h")
    val priceChange24h: Double? = null,

    @SerialName("price_change_percentage_24h")
    val priceChangePercentage24h: Double? = null,

    @SerialName("roi")
    val roi: Roi? = null,

    @SerialName("symbol")
    val symbol: String? = null,

    @SerialName("total_volume")
    val totalVolume: Long? = null
)

@Serializable
data class Roi(

    @SerialName("currency")
    val currency: String? = null,

    @SerialName("percentage")
    val percentage: Double? = null,

    @SerialName("times")
    val times: Double? = null
)
