package com.example.data.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import javax.inject.Inject

class Connectivity @Inject constructor(private val context: Context) {

  fun hasNetworkAccess(): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

    return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true
  }
}