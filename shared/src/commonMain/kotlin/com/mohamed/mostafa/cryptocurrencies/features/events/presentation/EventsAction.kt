package com.mohamed.mostafa.cryptocurrencies.features.events.presentation

import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.EventType

sealed class EventsAction {

    object GetEventTypes : EventsAction()

    data class GetEvents(val eventType: EventType) : EventsAction()
}
