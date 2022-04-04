package com.alex.weather.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.alex.weather.ui.WeatherDestinations.EVENT_ROUTE
import com.alex.weather.ui.WeatherDestinations.HOME_ROUTE

object WeatherDestinations {
    const val HOME_ROUTE = "home"
    const val EVENT_ROUTE = "event"
}

class WeatherNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(HOME_ROUTE) {
            navigate(navController)
        }
    }

    val navigateToInterests: () -> Unit = {
        navController.navigate(EVENT_ROUTE) {
            navigate(navController)
        }
    }

    private fun NavOptionsBuilder.navigate(navController: NavHostController) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}