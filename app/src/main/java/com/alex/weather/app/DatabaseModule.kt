package com.alex.weather.app

import android.content.Context
import androidx.room.Room
import com.alex.weather.data.local.room.WeatherEventDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideWeatherEventDao(appDatabase: AppDatabase): WeatherEventDao {
        return appDatabase.weatherEventDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "WeatherDatabase"
        ).build()
    }
}