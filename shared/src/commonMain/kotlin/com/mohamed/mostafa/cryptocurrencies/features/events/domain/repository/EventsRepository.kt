package com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository

interface EventsRepository {

    suspend fun getEventTypes(): List<String>
}