package com.example.androiddevchallenge.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

inline fun <reified T : Activity> Activity.startActivity(context: Context) {
    startActivity(Intent(context, T::class.java))
}

inline fun <reified T : Any> LiveData<T>.submit(t: T) {
    (this as? MutableLiveData)?.value = t
}

fun Context.showToast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
}