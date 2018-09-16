//package com.example.lkord.movies.interaction
//
//import android.util.Log
//import com.example.lkord.movies.MovieApp
//import com.example.lkord.movies.R
//import com.example.lkord.movies.model.data.Movie
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ValueEventListener
//import javax.inject.Inject
//
//private const val TAG = "FavoritesInteractor"
//
//class FavoritesInteractor @Inject constructor(private val firebaseDatabase: FirebaseDatabase)
//    : FavoritesInteractorInterface {
//
//    override fun getFavoriteMovies() {
//        firebaseDatabase.reference.addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(error: DatabaseError) {
//            }
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//               snapshot.child(MovieApp.instance.resources.getString(R.string.child_movies)).children.run {
//                    for (child in this) {
//                        val movie = child?.getValue(Movie::class.java)
//                        Log.d(TAG, movie?.title)
//                    }
//                }
//            }
//
//        })
//    }
//}
