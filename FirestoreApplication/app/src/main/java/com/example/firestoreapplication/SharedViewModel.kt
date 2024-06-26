// SharedViewModel.kt

package com.example.firestoreapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class SharedViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    fun saveData(userData: UserData, context: Context, callback: () -> Unit) {
        db.collection("users")
            .document(userData.userID)
            .set(userData)
            .addOnSuccessListener {
                showDialog(context, "User added successfully")
                callback()
            }
            .addOnFailureListener { e ->
                showDialog(context, "Error adding user: ${e.message}")
            }
    }

    fun retrieveData(userID: String, context: Context, data: (UserData?) -> Unit) {
        db.collection("users")
            .document(userID)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val userData = document.toObject(UserData::class.java)
                    data(userData)
                } else {
                    data(null)
                    showDialog(context, "No such document")
                }
            }
            .addOnFailureListener { e ->
                data(null)
                showDialog(context, "Error retrieving user: ${e.message}")
            }
    }

    fun updateData(userData: UserData, context: Context, callback: () -> Unit) {
        db.collection("users")
            .document(userData.userID)
            .set(userData)
            .addOnSuccessListener {
                showDialog(context, "User updated successfully")
                callback()
            }
            .addOnFailureListener { e ->
                showDialog(context, "Error updating user: ${e.message}")
            }
    }

    fun deleteData(userID: String, context: Context, callback: () -> Unit) {
        db.collection("users")
            .document(userID)
            .delete()
            .addOnSuccessListener {
                showDialog(context, "User deleted successfully")
                callback()
            }
            .addOnFailureListener { e ->
                showDialog(context, "Error deleting user: ${e.message}")
            }
    }
}
