package com.example.myapplication

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.launch
import java.util.*

class ImageUploadViewModel : ViewModel() {
    var selectedImageUri = mutableStateOf<Uri?>(null)
    var isUploading = mutableStateOf(false)
    var uploadSuccess = mutableStateOf(false)
    var uploadError = mutableStateOf<String?>(null)

    private val firestore = FirebaseFirestore.getInstance()
    private val storageRef = Firebase.storage.reference

    fun uploadImage(imageUri: Uri) {
        val documentId = UUID.randomUUID().toString()
        val imageRef = storageRef.child("images/$documentId.jpg")

        isUploading.value = true

        viewModelScope.launch {
            try {
                imageRef.putFile(imageUri).addOnSuccessListener {
                    isUploading.value = false
                    uploadSuccess.value = true
                }.addOnFailureListener { exception ->
                    isUploading.value = false
                    uploadError.value = exception.message
                }
            } catch (e: Exception) {
                isUploading.value = false
                uploadError.value = e.message
            }
        }
    }
}
