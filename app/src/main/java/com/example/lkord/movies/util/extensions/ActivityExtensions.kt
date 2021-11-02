@file:Suppress("UNCHECKED_CAST")

package com.example.lkord.movies.util.extensions

import android.widget.Toast
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.toast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}