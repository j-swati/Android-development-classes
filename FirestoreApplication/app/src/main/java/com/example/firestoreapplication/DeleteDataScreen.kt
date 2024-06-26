// DeleteDataScreen.kt

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
fun DeleteDataScreen(sharedViewModel: SharedViewModel) {
    var userID by remember { mutableStateOf("") }
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
                sharedViewModel.deleteData(userID, context) {
                    showDialog(context, "User deleted successfully")
                }
            }
        ) {
            Text(text = "Delete")
        }
    }
}
