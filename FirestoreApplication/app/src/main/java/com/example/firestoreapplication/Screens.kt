// Screens.kt

package com.example.firestoreapplication

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object AddDataScreen : Screens("add_data_screen")
    object GetDataScreen : Screens("get_data_screen")
    object UpdateDataScreen : Screens("update_data_screen")
    object DeleteDataScreen : Screens("delete_data_screen")
}
