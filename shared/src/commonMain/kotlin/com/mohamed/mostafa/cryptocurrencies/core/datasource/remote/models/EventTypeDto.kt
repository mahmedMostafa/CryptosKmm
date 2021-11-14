package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
data class EventTypeDto(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("data")
    val data: List<String>? = null
)