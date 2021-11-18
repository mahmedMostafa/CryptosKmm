package com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components


import android.graphics.Color.TRANSPARENT
import android.graphics.Color.WHITE
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.EventType

@Composable
fun EventTypes(
    types: List<EventType>,
    selectedType: EventType?,
    onItemClicked: (EventType) -> Unit
) {

    if (selectedType != null) {
        TabRow(
            selectedTabIndex = types.indexOf(selectedType),
            indicator = { tabPositions ->
                EventTypeTabIndicator(
                    tabPositions = tabPositions,
                    eventType = selectedType
                )
            },
            backgroundColor = Color.White,

        ) {
            types.forEach { eventType ->
                EventTypeItem(
                    eventType = eventType,
                    isSelected = eventType.title == selectedType.title,
                    onItemClicked = onItemClicked
                )
            }
        }
    }
}


@Composable
fun EventTypeTabIndicator(
    tabPositions: List<TabPosition>,
    eventType: EventType,
) {
    val transition = updateTransition(targetState = eventType, label = eventType.title)

    val indicatorLeft by transition.animateDp(
        label = eventType.title
    ) { type ->
        tabPositions[type.position].left
    }

    val indicatorRight by transition.animateDp(
        label = eventType.title,
    ) { type ->
        tabPositions[type.position].right
    }

    Box(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
            .offset(x = indicatorLeft)
            .width(indicatorRight - indicatorLeft)
            .padding(12.dp)
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .background(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(8.dp),
            )
            .zIndex(1f)
    )
}

@Composable
fun EventTypeItem(eventType: EventType, isSelected: Boolean, onItemClicked: (EventType) -> Unit) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) Color(WHITE) else MaterialTheme.colors.primary
    )
    Text(
        eventType.title,
        modifier = Modifier
            .padding(12.dp)
            .clickable {
                onItemClicked(eventType)
            }
            .border(
                2.dp,
                color = if (isSelected) Color(TRANSPARENT) else MaterialTheme.colors.primary,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .zIndex(2f),
        style = MaterialTheme.typography.body1.copy(
            color = textColor,
        ),
    )

}