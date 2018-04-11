package com.example.lkord.movies.api

import com.example.lkord.movies.model.data.Movie
import com.example.lkord.movies.model.network.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val OMDB_API_KEY = "31e475bb"

interface MovieApiService {

    @GET(".")
    fun searchMoviesByTitle(@Query("apiKey") apiKey: String = OMDB_API_KEY, @Query("s") title: String): Call<SearchResponse>

    @GET(".")
    fun detailedSearchByTitle(@Query("apiKey") apiKey: String = OMDB_API_KEY, @Query("t") title: String): Call<Movie>

    @GET("?apikey=$OMDB_API_KEY")
    fun getTopMovies(): Call<List<Movie>>
}