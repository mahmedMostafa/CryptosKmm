package com.mohamed.mostafa.cryptocurrencies.features.events.presentation

sealed class EventsAction {

    object GetEventTypes : EventsAction()

    data class GetEvents(val eventType: String) : EventsAction()
}
