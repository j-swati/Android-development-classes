package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Column {
        HorizontalDividerExample()
        Spacer(modifier = Modifier.height(16.dp)) // Adding spacing
        VerticalDividerExample()
    }
}

@Composable
fun HorizontalDividerExample() {
    Column(
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(8.dp),
    ) {
        Text("First item in list")
        HorizontalDivider(thickness = 2.dp)
        Text("Second item in list")
    }
}

@Composable
fun VerticalDividerExample() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
    ) {
        Text("First item in row")
        VerticalDivider(color = Color.Gray) // Adjust color according to your theme
        Text("Second item in row")
    }
}

@Composable
fun HorizontalDivider(thickness: Dp, color: Color = Color.Gray) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(thickness)
            .background(color)
    )
}

@Composable
fun VerticalDivider(thickness: Dp = 2.dp, color: Color = Color.Gray) {
    Box(
        modifier = Modifier
            .width(thickness)
            .fillMaxHeight()
            .background(color)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyApp()
    }
}
