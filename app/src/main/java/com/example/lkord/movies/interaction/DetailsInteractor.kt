package com.example.lkord.movies.interaction

import com.example.lkord.movies.network.MovieAPI
import com.example.lkord.movies.model.data.Movie
import com.google.firebase.database.FirebaseDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailsInteractor @Inject constructor(private val moviesApi: MovieAPI, private val firebase: FirebaseDatabase) : DetailsInteractorInterface {

    override fun saveMovieToDatabase(movie: Movie) {
        firebase.reference.child("movies").push().setValue(movie)
    }

    override fun getMovieWithDetails(searchQuery: String?, onResult: (Movie) -> Unit) {
        moviesApi.detailedSearchByTitle(title = searchQuery
                ?: "").enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                t?.printStackTrace()
//                Toast.makeText(MovieApp.instance, R.string.search_failed, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                response?.body()?.run { onResult(this) }
            }

        })
    }
}
