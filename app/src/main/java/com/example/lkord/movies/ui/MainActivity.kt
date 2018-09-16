package com.example.lkord.movies.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.lkord.movies.R
import com.example.lkord.movies.viewModels.MainViewModel
import com.example.lkord.movies.viewModels.MainViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

//import android.app.SearchManager
//import android.content.Context
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.view.Menu
//import com.example.lkord.movies.R
//import com.example.lkord.movies.common.extensions.onItemTapped
//import com.example.lkord.movies.ui.favourites.FavouritesFragment
//import com.example.lkord.movies.ui.home.HomeFragment
//import kotlinx.android.synthetic.main.activity_main.*
//
class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, viewModelFactory)
//
//        fragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()
//
//        navigation.onItemTapped {
//            when (it) {
//                R.id.navigation_home -> {
//                    fragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()
//                }
//
//                R.id.navigation_favourites -> {
//                    fragmentManager.beginTransaction().replace(R.id.container, favouritesFragment).commit()
//                }
//            }
//        }
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as? SearchManager
//        val searchView = menu?.findItem(R.id.app_bar_search)?.actionView as? android.widget.SearchView
//        searchView?.setSearchableInfo(searchManager?.getSearchableInfo(componentName))
//
//        return true
//    }
    }
}
