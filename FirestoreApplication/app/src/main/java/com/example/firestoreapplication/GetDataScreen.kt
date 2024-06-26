// GetDataScreen.kt

package com.example.firestoreapplication

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun GetDataScreen(sharedViewModel: SharedViewModel) {
    var userID by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var profession by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    val context = LocalContext.current as ComponentActivity

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            modifier = Modifier.padding(16.dp),
            value = userID,
            onValueChange = { userID = it },
            label = { Text(text = "UserID") }
        )
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {
                sharedViewModel.retrieveData(userID, context) { userData ->
                    if (userData != null) {
                        name = userData.name
                        profession = userData.profession
                        age = userData.age.toString()
                    } else {
                        showDialog(context, "Invalid user ID")
                    }
                }
            }
        ) {
            Text(text = "Get Data")
        }
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Name: $name\nProfession: $profession\nAge: $age"
        )
    }
}
