package com.alex.weather.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherEventDao {

    @Query("SELECT * FROM weather_event")
    fun getAllWeatherEvents(): Flow<List<WeatherEventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllWeatherEvent(weatherEventList: List<WeatherEventEntity>)
}