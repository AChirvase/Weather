package com.alex.weather.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_event")
data class WeatherEventEntity(
    @PrimaryKey
    val id: String,
    val event: String,
    val description: String
)