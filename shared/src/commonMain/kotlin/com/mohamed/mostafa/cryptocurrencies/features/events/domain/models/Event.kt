package com.mohamed.mostafa.cryptocurrencies.features.events.domain.models

import kotlinx.serialization.SerialName

data class Event(
    val address: String? = null,
    val city: String? = null,
    val country: String? = null,
    val description: String? = null,
    val email: String? = null,
    val endDate: String? = null,
    val organizer: String? = null,
    val screenshot: String? = null,
    val startDate: String? = null,
    val title: String? = null,
    val type: String? = null,
    val venue: String? = null,
    val website: String? = null
)
