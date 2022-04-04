package com.alex.weather

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alex.weather.feature.homefeed.HomeFeedScreen
import com.alex.weather.feature.homefeed.HomeFeedViewModel
import com.alex.weather.ui.WeatherDestinations.HOME_ROUTE
import com.alex.weather.ui.theme.WeatherTheme

@Composable
fun MviApp() {
    val navController = rememberNavController()
    WeatherTheme {
        Scaffold(
            content = {
                NavHost(navController = navController, startDestination = HOME_ROUTE) {
                    mainScreenRoute(navController = navController)
                }
            }
        )
    }
}

private fun NavGraphBuilder.mainScreenRoute(navController: NavController) {
    composable(HOME_ROUTE) {
        val viewModel = hiltViewModel<HomeFeedViewModel>()
        HomeFeedScreen(viewModel = viewModel)
    }
}