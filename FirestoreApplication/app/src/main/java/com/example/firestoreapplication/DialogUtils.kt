// DialogUtils.kt

package com.example.firestoreapplication

import android.app.AlertDialog
import android.content.Context

fun showDialog(context: Context, message: String) {
    AlertDialog.Builder(context).apply {
        setTitle("Operation Result")
        setMessage(message)
        setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        create()
        show()
    }
}
