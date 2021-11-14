package com.mohamed.mostafa.cryptocurrencies.features.events.data.repository

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository.EventsRepository
import io.ktor.client.*

class EventsRepositoryImpl(
    private val apiService: ApiService,
) : EventsRepository {

    override suspend fun getEventTypes(): List<String> {
        return apiService.getEventTypes().data ?: emptyList()
    }
}