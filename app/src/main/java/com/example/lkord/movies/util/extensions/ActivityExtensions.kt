@file:Suppress("UNCHECKED_CAST")

package com.example.lkord.movies.util.extensions

import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lkord.movies.App

inline fun <reified T : ViewModel> FragmentActivity.viewModel(crossinline provider: () -> T) =
    viewModels<T> {
      object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>) = provider() as T
      }
    }

inline fun <reified T : ViewModel> Fragment.viewModel(crossinline provider: () -> T) =
    viewModels<T> {
      object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>) = provider() as T
      }
    }

inline fun <reified T : ViewModel> Fragment.activityViewModel(crossinline provider: () -> T) =
    activityViewModels<T> {
      object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>) = provider() as T
      }
    }

val Fragment.injector get() = App.appComponent

fun FragmentActivity.toast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun FragmentManager.replace(container: Int, fragment: Fragment) {
  this.beginTransaction().replace(container, fragment).commit()
}