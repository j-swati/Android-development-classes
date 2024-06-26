// AddDataScreen.kt

package com.example.firestoreapplication

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun AddDataScreen(sharedViewModel: SharedViewModel) {
    var userID by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var profession by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current as ComponentActivity

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = userID,
            onValueChange = { userID = it },
            label = { Text(text = "UserID") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = profession,
            onValueChange = { profession = it },
            label = { Text(text = "Profession") }
        )
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = age,
            onValueChange = { age = it },
            label = { Text(text = "Age") }
        )
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {
                val userData = UserData(userID, name, profession, age.toIntOrNull() ?: 0)
                isLoading = true
                sharedViewModel.saveData(userData, context) {
                    isLoading = false
                    showDialog(context, "User added successfully")
                }
            }
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                Text(text = "Add")
            }
        }
    }
}
