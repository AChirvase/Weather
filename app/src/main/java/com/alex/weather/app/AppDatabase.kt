package com.alex.weather.app

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alex.weather.app.utils.WeatherTypeConverters
import com.alex.weather.data.local.room.WeatherEventDao
import com.alex.weather.data.local.room.WeatherEventEntity

@Database(entities = [WeatherEventEntity::class], version = 1)
@TypeConverters(WeatherTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherEventDao(): WeatherEventDao
}