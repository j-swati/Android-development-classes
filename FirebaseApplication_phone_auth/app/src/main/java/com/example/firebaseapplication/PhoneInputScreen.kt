// PhoneInputScreen.kt

package com.example.firebaseapplication

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PhoneInputScreen(navController: NavController, viewModel: AuthViewModel = viewModel()) {
    val phoneNumber = remember { mutableStateOf("") }
    val authState by viewModel.authState.collectAsState()
    val context = LocalContext.current as ComponentActivity

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            label = { Text(text = "Enter Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.verifyPhoneNumber(phoneNumber.value, context) }) {
            Text(text = "Send OTP")
        }

        when (authState) {
            is AuthState.CodeSent -> {
                LaunchedEffect(authState) {
                    navController.navigate("otpVerification")
                }
            }
            is AuthState.Error -> {
                Text("Error: ${(authState as AuthState.Error).message}")
            }
            else -> {}
        }
    }
}
