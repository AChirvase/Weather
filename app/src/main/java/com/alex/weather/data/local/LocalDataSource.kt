package com.alex.weather.data.local

import com.alex.weather.data.local.room.WeatherEventDao
import com.alex.weather.data.local.room.WeatherEventEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LocalDataSource {
    fun getAllWeatherEvents(): Flow<List<WeatherEventEntity>>
    fun addAllWeatherEvent(weatherEventList: List<WeatherEventEntity>)
}

class LocalDataSourceImpl @Inject constructor(private val weatherEventDao: WeatherEventDao) :
    LocalDataSource {

    override fun getAllWeatherEvents(): Flow<List<WeatherEventEntity>> =
        weatherEventDao.getAllWeatherEvents()

    override fun addAllWeatherEvent(weatherEventList: List<WeatherEventEntity>) =
        weatherEventDao.addAllWeatherEvent(weatherEventList)
}