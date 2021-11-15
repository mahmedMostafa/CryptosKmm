package com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository.EventsRepository

class GetEvents(
    private val repository: EventsRepository,
) : SingleUseCase<List<Event>, String>() {

    override suspend fun buildUseCase(params: String?): List<Event> {
        return repository.getEvents(params ?: "")
    }
}