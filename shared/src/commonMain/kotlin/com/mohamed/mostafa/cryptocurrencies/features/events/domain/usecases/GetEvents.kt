package com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases

import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.FlowUseCase
import com.mohamed.mostafa.cryptocurrencies.core.base.usecases.SingleUseCase
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.repository.EventsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetEvents(
    private val repository: EventsRepository,
) {

    suspend operator fun invoke(eventType: String?): Flow<List<Event>> = flow {
        delay(2000)//Just to show the Loading
        val data = repository.getEvents(eventType ?: "")
        println("Data is $data")
        emit(data)
    }
}