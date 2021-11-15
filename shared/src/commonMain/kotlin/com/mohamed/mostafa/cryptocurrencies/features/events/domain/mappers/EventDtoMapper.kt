package com.mohamed.mostafa.cryptocurrencies.features.events.domain.mappers

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.models.EventDto
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event

fun EventDto.toDomainModel(): Event {
    return Event(
        address = address,
        city = city,
        country = country,
        description = description,
        email = email,
        endDate = endDate,
        organizer = organizer,
        screenshot = screenshot,
        startDate = startDate,
        title = title,
        type = type,
        venue = venue,
        website = website
    )
}

fun List<EventDto>.toDomainList(): List<Event> {
    return map { it.toDomainModel() }
}