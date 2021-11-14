package com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository.EventsRepository

class GetEventTypes(
    private val repository: EventsRepository,
) : SingleUseCase<List<String>, Unit>() {

    override suspend fun buildUseCase(params: Unit?): List<String> {
        return repository.getEventTypes()
    }
}