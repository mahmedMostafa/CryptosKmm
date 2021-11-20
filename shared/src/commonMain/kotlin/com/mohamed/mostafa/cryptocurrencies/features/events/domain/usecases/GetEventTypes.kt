package com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.EventType
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository.EventsRepository
import kotlinx.coroutines.flow.flow

class GetEventTypes(
    private val repository: EventsRepository,
) {

    suspend operator fun invoke() = flow {
        emit(
            repository.getEventTypes().mapIndexed { index: Int, title: String ->
                EventType(
                    title = title,
                    position = index,
                )
            }
        )
    }
}