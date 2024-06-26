// NavGraph.kt

package com.example.firestoreapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController, sharedViewModel: SharedViewModel) {
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) {
            MainScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable(route = Screens.AddDataScreen.route) {
            AddDataScreen(sharedViewModel = sharedViewModel)
        }
        composable(route = Screens.GetDataScreen.route) {
            GetDataScreen(sharedViewModel = sharedViewModel)
        }
        composable(route = Screens.UpdateDataScreen.route) {
            UpdateDataScreen(sharedViewModel = sharedViewModel)
        }
        composable(route = Screens.DeleteDataScreen.route) {
            DeleteDataScreen(sharedViewModel = sharedViewModel)
        }
    }
}
