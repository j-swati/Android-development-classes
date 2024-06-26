// OtpVerificationScreen.kt

package com.example.firebaseapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun OtpVerificationScreen(navController: NavController, viewModel: AuthViewModel = viewModel()) {
    var otpCode by remember { mutableStateOf("") }
    val authState by viewModel.authState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = otpCode,
            onValueChange = { otpCode = it },
            label = { Text("OTP Code") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.verifyCode(otpCode) }) {
            Text("Verify Code")
        }

        when (authState) {
            is AuthState.Success -> {
                LaunchedEffect(authState) {
                    navController.navigate("success")
                }
            }
            is AuthState.Error -> {
                Text("Error: ${(authState as AuthState.Error).message}")
            }
            else -> {}
        }
    }
}
