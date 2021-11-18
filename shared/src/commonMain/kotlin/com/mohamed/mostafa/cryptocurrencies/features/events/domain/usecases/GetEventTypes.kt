package com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.EventType
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository.EventsRepository

class GetEventTypes(
    private val repository: EventsRepository,
) : SingleUseCase<List<EventType>, Unit>() {

    override suspend fun buildUseCase(params: Unit?): List<EventType> {
        return repository.getEventTypes().mapIndexed { index: Int, title: String ->
            EventType(
                title = title,
                position = index,
//                isSelected = index == 0
            )
        }
    }
}