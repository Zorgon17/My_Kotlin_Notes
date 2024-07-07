package com.example.kotlin_notes.ui.navigate

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_notes.ui.screens.AddScreenScaffold
import com.example.kotlin_notes.ui.screens.HomeScreen
import com.example.kotlin_notes.ui.screens.HomeScreenScaffold

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    innerPaddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = HomeScreen.Start.name) {

        composable(route = HomeScreen.Start.name) {
            HomeScreenScaffold(innerPaddingValues, navController)
        }

        composable(route = HomeScreen.Add.name) {
            AddScreenScaffold(innerPaddingValues,navController)
        }

    }
}

enum class HomeScreen() {
    Start,
    Add
}
