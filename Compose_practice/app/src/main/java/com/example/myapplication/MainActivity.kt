package com.example.myapplication

import android.os.Bundle
import android.util.Size
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush

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
                    TextWithModifiers()
                }
            }
        }
    }
}

@Composable
fun TextWithModifiers() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Bold Text",
                modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Italic Text",
                modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
            )
            Text(
                text = "Underlined Text",
                modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Font Size 24sp",
                modifier = Modifier
                    .padding(8.dp),
                style = TextStyle(fontSize = 24.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Gradient",
                modifier = Modifier
                ,style = TextStyle(
                    fontSize = 24.sp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Cyan, Color.Red,Color.Blue)
                        )
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Padding",
                modifier = Modifier
                    .padding(all = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Background",
                modifier = Modifier
                    .background(color = Color.Gray)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Clickable",
                modifier = Modifier
                    .clickable { /* Handle click */ }
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Fill Max Width",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Size",
                modifier = Modifier
                    .size(width = 100.dp, height = 50.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Border",
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Black)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = "Text with Rotate",
                modifier = Modifier
                    .rotate(45f)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = "Text with ZIndex",
                modifier = Modifier
                    .zIndex(1f)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Text with Shadow",
                modifier = Modifier
                    .shadow(elevation = 4.dp)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Your composable content here
        }
    }
}
