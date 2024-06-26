// MainScreen.kt

package com.example.firestoreapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, sharedViewModel: SharedViewModel) {
    Column {
        Button(
            onClick = { navController.navigate(Screens.AddDataScreen.route) }
        ) {
            Text(text = "Add Data")
        }
        Button(
            onClick = { navController.navigate(Screens.GetDataScreen.route) }
        ) {
            Text(text = "Get Data")
        }
        Button(
            onClick = { navController.navigate(Screens.UpdateDataScreen.route) }
        ) {
            Text(text = "Update Data")
        }
        Button(
            onClick = { navController.navigate(Screens.DeleteDataScreen.route) }
        ) {
            Text(text = "Delete Data")
        }
    }
}
