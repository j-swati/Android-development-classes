package com.example.myapplication

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun UploadImageScreen(viewModel: ImageUploadViewModel = viewModel()) {
    val imageUri by viewModel.selectedImageUri
    val isUploading by viewModel.isUploading
    val uploadSuccess by viewModel.uploadSuccess
    val uploadError by viewModel.uploadError

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { viewModel.selectedImageUri.value = it }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { launcher.launch("image/*") }) {
                Text("Select Image")
            }

            Spacer(modifier = Modifier.height(16.dp))

            imageUri?.let {
                Image(
                    painter = rememberAsyncImagePainter(model = it),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    imageUri?.let { viewModel.uploadImage(it) }
                },
                enabled = !isUploading
            ) {
                Text("Upload Image")
            }

            if (isUploading) {
                CircularProgressIndicator()
            }

            if (uploadSuccess) {
                AlertDialog(
                    onDismissRequest = { viewModel.uploadSuccess.value = false },
                    title = { Text(text = "Upload Successful") },
                    text = { Text("Your image has been uploaded successfully.") },
                    confirmButton = {
                        Button(onClick = { viewModel.uploadSuccess.value = false }) {
                            Text("OK")
                        }
                    }
                )
            }

            uploadError?.let { error ->
                Text(text = "Upload failed: $error", color = MaterialTheme.colors.error)
            }
        }
    }
}
