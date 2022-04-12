package com.alex.weather.data

import com.alex.weather.data.local.room.WeatherEventEntity
import com.alex.weather.data.remote.api.WeatherEventResponse
import com.alex.weather.domain.WeatherEvent

fun WeatherEventResponse.toEntity(): WeatherEventEntity {
    return WeatherEventEntity(
        id = id,
        event = event,
        description = description,
        effective = effective,
        ends = ends,
        senderName = senderName,
        severity = severity,
        certainty = certainty
    )
}