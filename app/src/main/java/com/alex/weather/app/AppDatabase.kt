package com.alex.weather.app

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alex.weather.data.local.room.WeatherEventDao
import com.alex.weather.data.local.room.WeatherEventEntity

@Database(entities = [WeatherEventEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherEventDao(): WeatherEventDao
}