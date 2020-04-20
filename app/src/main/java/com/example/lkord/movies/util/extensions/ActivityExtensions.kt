package com.example.lkord.movies.util.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> Fragment.getViewModel(factory: ViewModelProvider.Factory): T {
  return ViewModelProvider(this, factory).get(T::class.java)
}

fun FragmentActivity.toast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun FragmentManager.replace(container: Int, fragment: Fragment) {
  this.beginTransaction().replace(container, fragment).commit()
}