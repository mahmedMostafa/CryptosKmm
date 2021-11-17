package com.mohamed.mostafa.cryptocurrencies.android.presentation.events

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Path.Companion.combine
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEventTypes
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEvents
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsAction
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getEventsTypes: GetEventTypes,
    private val getEvents: GetEvents,
) : ViewModel() {


    val state = mutableStateOf(EventsState())


    init {
        onTriggerAction(EventsAction.GetEventTypes)

    }

    fun onTriggerAction(action: EventsAction) {
        when (action) {
            is EventsAction.GetEventTypes -> getEventsTypes()
            is EventsAction.GetEvents -> getEvents(eventType = action.eventType)
        }
    }

    private fun getEventsTypes() = viewModelScope.launch {
        getEventsTypes.invoke(
            onLoading = { isLoading ->
//                state.value = state.value.copy(isLoading = isLoading)
            },
            onError = { errorMessage ->
                state.value = state.value.copy(errorMessage = errorMessage)
            },
            onSuccess = { eventTypes ->
                state.value = state.value.copy(eventTypes = eventTypes)
                //get the events of the first event type
                //later on we should use flow combine which is better and cleaner
                onTriggerAction(EventsAction.GetEvents(eventTypes.first()))//TODO Error
                println("Event Types are $eventTypes")
            }
        )
    }

    private fun getEvents(eventType: String) = viewModelScope.launch {
        state.value = state.value.copy(selectedEventType = eventType)
        getEvents.invoke(
            params = eventType,
            onLoading = { isLoading ->
                state.value = state.value.copy(isLoading = isLoading)
            },
            onSuccess = { events ->
                state.value = state.value.copy(events = events)
                println("Events are $events")
            },
            onError = { errorMessage ->
                state.value = state.value.copy(errorMessage = errorMessage)
            }
        )
    }
}