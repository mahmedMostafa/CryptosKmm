package com.mohamed.mostafa.cryptocurrencies.android.presentation.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohamed.mostafa.cryptocurrencies.android.base.components.DefaultScreen
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsAction
import com.mohamed.mostafa.cryptocurrencies.features.events.presentation.EventsState


@Composable
fun EventsScreen(
    state: EventsState,
    onTriggerAction: (EventsAction) -> Unit,
) {

    DefaultScreen(isLoading = state.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                items(state.eventTypes) { type ->
                    Text(
                        type,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .padding(12.dp)
                            .clickable {
                                onTriggerAction(EventsAction.GetEvents(type))
                            },
                    )
                }
            }
        }
    }
}