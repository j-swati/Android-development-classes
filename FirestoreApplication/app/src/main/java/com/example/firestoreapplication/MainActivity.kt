// MainActivity.kt

package com.example.firestoreapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.firestoreapplication.ui.theme.FirestoreApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirestoreApplicationTheme {
                val navController = rememberNavController()
                val sharedViewModel = SharedViewModel() // Instantiate your shared view model

                NavGraph(navController = navController, sharedViewModel = sharedViewModel)
            }
        }
    }
}
