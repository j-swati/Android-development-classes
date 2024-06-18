package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicButton()
        ElevatedButton()
        OutlinedButton()
        TextButton()
        FilledButton()
    }
}

@Composable
fun BasicButton() {
    Button(onClick = { /* Handle button click */ }) {
        Text("Basic Button")
    }
}

@Composable
fun ElevatedButton() {
    ElevatedButton(onClick = { /* Handle button click */ }) {
        Text("Elevated Button")
    }
}

@Composable
fun OutlinedButton() {
    OutlinedButton(onClick = { /* Handle button click */ }) {
        Text("Outlined Button")
    }
}

@Composable
fun TextButton() {
    TextButton(onClick = { /* Handle button click */ }) {
        Text("Text Button")
    }
}

@Composable
fun FilledButton() {
    Button(onClick = { /* Handle button click */ }) {
        Text("Filled Button")
    }
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    MyApplicationTheme {
        MainContent()
    }
}
