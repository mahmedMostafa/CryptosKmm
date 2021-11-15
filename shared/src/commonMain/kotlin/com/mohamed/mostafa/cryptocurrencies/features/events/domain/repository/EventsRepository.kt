package com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository

import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event

interface EventsRepository {

    suspend fun getEventTypes(): List<String>

    suspend fun getEvents(eventType: String): List<Event>
}