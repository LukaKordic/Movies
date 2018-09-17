package com.example.lkord.movies.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.example.lkord.movies.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
    }

    override fun onResume() {
        super.onResume()
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigationSearch -> {
                    searchQuery.visibility = View.VISIBLE
                    true
                }
                else -> {
                    searchQuery.visibility = View.GONE
                    true
                }
            }
        }
    }
}
