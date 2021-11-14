package com.mohamed.mostafa.cryptocurrencies.features.events.presentation

data class EventsState(
    val isLoading : Boolean,
    val errorMessage : String,//It might have more than one error message like that!
    val eventTypes : List<String> = emptyList(),
)
