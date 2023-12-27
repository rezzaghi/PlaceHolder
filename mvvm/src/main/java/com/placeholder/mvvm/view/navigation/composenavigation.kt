package com.placeholder.mvvm.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.placeholder.mvvm.view.requestscreen.RequestScreen
import com.placeholder.mvvm.view.startscreen.StartScreen

@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "startscreen"){
        composable("startscreen"){
            StartScreen(navController)
        }
        composable("requestscreen"){
            RequestScreen()
        }
    }
}
