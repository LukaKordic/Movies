package com.example.lkord.movies.interaction

import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject


class FavoritesInteractor @Inject constructor(private val firebaseDatabase: FirebaseDatabase) : FavoritesInteractorInterface {

    override fun getFavoriteMovies() {

    }
}