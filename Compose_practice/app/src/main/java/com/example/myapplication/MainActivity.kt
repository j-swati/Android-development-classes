package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                StaggeredGridScreen()
            }
        }
    }
}

@Composable
fun StaggeredGridScreen() {
    val randomSizedPhotos = listOf(
        "https://i.pinimg.com/564x/26/01/c4/2601c4d273d8a2098f343499cdb32f44.jpg",
        "https://i.pinimg.com/236x/2c/18/c4/2c18c4574f8642a83b361c394b339112.jpg",
        "https://i.pinimg.com/564x/dc/01/ce/dc01ce6b351f5525931d9c4f99a80658.jpg",
        "https://i.pinimg.com/564x/a3/4f/fb/a34ffb176641c47c65afaa2e89e209a5.jpg",
        "https://i.pinimg.com/564x/26/01/c4/2601c4d273d8a2098f343499cdb32f44.jpg",
        "https://i.pinimg.com/236x/2c/18/c4/2c18c4574f8642a83b361c394b339112.jpg",
        "https://i.pinimg.com/564x/dc/01/ce/dc01ce6b351f5525931d9c4f99a80658.jpg",
        "https://i.pinimg.com/564x/a3/4f/fb/a34ffb176641c47c65afaa2e89e209a5.jpg",
        "https://i.pinimg.com/564x/26/01/c4/2601c4d273d8a2098f343499cdb32f44.jpg",
        "https://i.pinimg.com/236x/2c/18/c4/2c18c4574f8642a83b361c394b339112.jpg",
        "https://i.pinimg.com/564x/dc/01/ce/dc01ce6b351f5525931d9c4f99a80658.jpg",
        "https://i.pinimg.com/564x/a3/4f/fb/a34ffb176641c47c65afaa2e89e209a5.jpg"
        
    )

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2), 
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(randomSizedPhotos.size) { index ->
            val photo = randomSizedPhotos[index]
            AsyncImage(
                model = photo,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }
    }
}
