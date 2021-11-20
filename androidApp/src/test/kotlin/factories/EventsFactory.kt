package factories

import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.EventType


val eventTypes = listOf(
    EventType(title = "Event Type 1", position = 0),
    EventType(title = "Event Type 2", position = 1),
    EventType(title = "Event Type 3", position = 2),
    EventType(title = "Event Type 4", position = 3),
)


val events = listOf(
    Event(
        title = "Event 1",
    ),
    Event(
        title = "Event 2",
    ),
    Event(
        title = "Event 3",
    ),
)