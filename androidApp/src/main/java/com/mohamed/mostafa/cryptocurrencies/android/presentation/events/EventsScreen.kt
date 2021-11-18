package com.mohamed.mostafa.cryptocurrencies.android.presentation.events


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohamed.mostafa.cryptocurrencies.android.base.components.DefaultScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components.EventTypes
import com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components.EventsList
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.EventType
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsAction
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsState


@Composable
fun EventsScreen(
    state: EventsState,
    onTriggerAction: (EventsAction) -> Unit,
) {

    var showMenu by remember { mutableStateOf(false) }

    DefaultScreen(
        isLoading = false,//we want to show our loading shimmer effect
        topBar = {
            TopAppBar(
                title = {
                    Text("Events")
                },
                actions = {
//                    DropdownMenu(
//                        expanded = showMenu,
//                        onDismissRequest = { showMenu = false }
//                    ) {
//
//                    }
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
                selectedType = state.selectedEventType,
                onItemClicked = { type ->
                    onTriggerAction(EventsAction.GetEvents(type))
                }
            )
            EventsList(isLoading = state.isLoading, events = state.events)
        }
    }
}