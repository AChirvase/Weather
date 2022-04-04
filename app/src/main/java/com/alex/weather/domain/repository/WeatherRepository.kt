package com.alex.weather.domain.repository

import com.alex.weather.domain.WeatherEvent
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getWeatherEvents(): Flow<List<WeatherEvent>>
}