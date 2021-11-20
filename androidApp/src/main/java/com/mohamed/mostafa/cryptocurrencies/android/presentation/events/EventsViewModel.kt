package com.mohamed.mostafa.cryptocurrencies.android.presentation.events

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Path.Companion.combine
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.EventType
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEventTypes
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.usecases.GetEvents
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsAction
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class EventsViewModel @Inject constructor(
//    private val savedStateHandle: SavedStateHandle,
    private val getEventsTypes: GetEventTypes,
    private val getEvents: GetEvents,
) : ViewModel() {

    val eventTypes = MutableStateFlow<List<EventType>>(emptyList())
    val selectedEventType = MutableSharedFlow<EventType?>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val isLoadingEvenTypes = MutableStateFlow(false)
    val isLoadingEvents = MutableStateFlow(false)

    val events = selectedEventType
        .filter { !(it?.title.isNullOrBlank()) }
        .distinctUntilChanged()
        .flatMapLatest { type ->
            if (isLoadingEvents.value) {
                //Cancel the current running job to start a new one
                currentCoroutineContext().cancel()
            }
            isLoadingEvents.value = true
            getEvents.invoke(type?.title)
        }
        .onStart { isLoadingEvents.value = true }
        .onEach { isLoadingEvents.value = false }
        .catch { println("Events Error") }
        .cancellable()
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            emptyList(),
        )


    init {
        getEventsTypes()
    }

    fun onEventTypeChanged(type: EventType) = viewModelScope.launch {
        selectedEventType.tryEmit(type)
    }

    fun getEventsTypes() = viewModelScope.launch {
        isLoadingEvenTypes.value = true
        getEventsTypes.invoke().collect { types ->
            println("Types are $types")
            isLoadingEvenTypes.value = false
            eventTypes.value = types
            if (types.isNotEmpty()) {
                selectedEventType.tryEmit(types.first())
            } else {
                //Handle this error
            }
        }//TODO Add Error handeling
    }
}