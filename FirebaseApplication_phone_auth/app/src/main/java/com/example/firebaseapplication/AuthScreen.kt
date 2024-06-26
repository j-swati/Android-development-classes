// AUthScreen.kt

package com.example.firebaseapplication

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebaseapplication.ui.theme.FirebaseApplicationTheme

@Composable
fun AuthScreen(
    navController: NavHostController,
    viewModel: AuthViewModel,
    activity: ComponentActivity // Pass the activity as an argument
) {
    var phoneNumber by remember { mutableStateOf("") }
    val state by viewModel.authState.collectAsState()

    when (state) {
        is AuthState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                CircularProgressIndicator()
            }
        }
        is AuthState.Success -> navController.navigate("success")
        is AuthState.Error -> {
            Text(
                (state as AuthState.Error).message,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text("Phone Number") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        viewModel.verifyPhoneNumber(phoneNumber, activity = activity) // Use the passed activity
                    }
                ) {
                    Text("Verify Phone Number")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    FirebaseApplicationTheme {
        val navController = rememberNavController()
        val dummyActivity = ComponentActivity() // Create a dummy activity instance for preview
        val viewModel = AuthViewModel() // Ensure AuthViewModel has a no-arg constructor or use a mocked instance
        AuthScreen(navController = navController, viewModel = viewModel, activity = dummyActivity)
    }
}
