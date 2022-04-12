package com.alex.weather.feature.homefeed

sealed class HomeFeedItem {

    data class EventWeatherItem(
        val id: String,
        val event: String?,
        val description: String?,
        val effective: String?,
        val ends: String?,
        val senderName: String?
    ) : HomeFeedItem()

}
