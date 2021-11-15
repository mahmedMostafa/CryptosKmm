package com.mohamed.mostafa.cryptocurrencies.features.events.presentation

import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow

data class EventsState(
    val isLoading: Boolean,
    val errorMessage: String? = null,//It might have more than one error message like that!
    val eventTypes: List<String> = emptyList(),
    val selectedEventType: String? = null,
    val events: List<Event> = emptyList(),
) {

    constructor() : this(
        isLoading = true,
        errorMessage = null,
        eventTypes = emptyList(),
        selectedEventType = null,
        events = emptyList()
    )
}
