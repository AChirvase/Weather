package com.alex.weather.app.utils

import androidx.room.TypeConverter
import com.google.gson.Gson

class WeatherTypeConverters {

    @TypeConverter
    fun listToJson(value: MutableList<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String): MutableList<String> {
        return Gson().fromJson(value, Array<String>::class.java).toMutableList()
    }

}