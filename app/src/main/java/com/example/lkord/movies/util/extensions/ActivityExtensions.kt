package com.example.lkord.movies.util.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import android.widget.Toast

inline fun <reified T : ViewModel> Fragment.getViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory).get(T::class.java)
}

fun FragmentActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun FragmentManager.replace(container: Int, fragment: Fragment) {
    this.beginTransaction().replace(container, fragment).commit()
}