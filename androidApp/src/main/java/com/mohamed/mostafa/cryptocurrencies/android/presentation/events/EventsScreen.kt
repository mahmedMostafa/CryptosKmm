package com.mohamed.mostafa.cryptocurrencies.android.presentation.events


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohamed.mostafa.cryptocurrencies.android.base.components.DefaultScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components.EventTypes
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components.EventsList
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsAction
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsState


@Composable
fun EventsScreen(
    state: EventsState,
    onTriggerAction: (EventsAction) -> Unit,
) {

    DefaultScreen(
        isLoading = state.isLoading,
        topBar = {
            TopAppBar(
                title = {
                    Text("Events")
                }
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            EventTypes(
                types = state.eventTypes,
                selectedType = state.selectedEventType ?: "",
                onItemClicked = { type ->
                    onTriggerAction(EventsAction.GetEvents(type))
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            EventsList(isLoading = state.isLoading, events = state.events)
        }
    }
}