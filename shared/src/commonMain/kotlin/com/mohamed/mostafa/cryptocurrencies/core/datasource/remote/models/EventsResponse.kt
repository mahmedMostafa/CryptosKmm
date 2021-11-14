package com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName


@Serializable
data class EventsResponse(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("data")
    val `data`: List<EventDto>? = null,
    @SerialName("page")
    val page: Int? = null
)

@Serializable
data class EventDto(
    @SerialName("address")
    val address: String? = null,
    @SerialName("city")
    val city: String? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("end_date")
    val endDate: String? = null,
    @SerialName("organizer")
    val organizer: String? = null,
    @SerialName("screenshot")
    val screenshot: String? = null,
    @SerialName("start_date")
    val startDate: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("venue")
    val venue: String? = null,
    @SerialName("website")
    val website: String? = null
)