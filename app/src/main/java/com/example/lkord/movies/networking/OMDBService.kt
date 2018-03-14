package com.example.lkord.movies.networking

import com.example.lkord.movies.common.OMDB_API_KEY
import com.example.lkord.movies.dataobjects.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBService {

    @GET("?apikey=$OMDB_API_KEY")
    fun searchMoviesByTitle(@Query("t") title: String?): Call<Movie>

    @GET("?apikey=$OMDB_API_KEY")
    fun getTopMovies(): Call<List<Movie>>
}