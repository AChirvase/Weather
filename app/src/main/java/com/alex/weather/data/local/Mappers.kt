package com.alex.weather.data.local

import com.alex.weather.data.local.room.WeatherEventEntity
import com.alex.weather.domain.WeatherEvent

fun WeatherEventEntity.toDomain(): WeatherEvent {
    return WeatherEvent(
        id = id,
        event = event,
        description = description
    )
}
