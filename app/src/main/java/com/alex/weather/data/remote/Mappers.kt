package com.alex.weather.data.remote

import com.alex.weather.data.remote.api.WeatherEventResponse
import com.alex.weather.domain.WeatherEvent

fun WeatherEventResponse.toDomain(): WeatherEvent {
    return WeatherEvent(
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