// MainScreen.kt

package com.example.firebaseapplication

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseapplication.ui.theme.FirebaseApplicationTheme

@Composable
fun MainScreen(activity: ComponentActivity, viewModel: AuthViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "auth") {
        composable("auth") {
            PhoneInputScreen(navController = navController, viewModel = viewModel)
        }
        composable("otpVerification") {
            OtpVerificationScreen(navController = navController, viewModel = viewModel)
        }
        composable("success") {
            SuccessScreen(navController = navController, viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    FirebaseApplicationTheme {
        MainScreen(activity = ComponentActivity())
    }
}
