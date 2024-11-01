package com.fandyrs.jetpackcomposenavigation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fandyrs.jetpackcomposenavigation.ui.detail.DetailScreen
import com.fandyrs.jetpackcomposenavigation.ui.main.MainScreen

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Detail.route, arguments =
        listOf(
            navArgument("text") {
                type = NavType.StringType
                nullable = true
            }
        )
        ) { args ->
            DetailScreen(text = args.arguments?.getString("text"))
        }
    }
}

sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
    object Detail : Screen("detail_screen")
}