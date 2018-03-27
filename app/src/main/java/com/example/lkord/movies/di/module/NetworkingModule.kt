package com.example.lkord.movies.di.module

import com.example.lkord.movies.api.MovieApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private const val BASE_URL = "http://www.omdbapi.com/"

@Module
@Singleton
class NetworkingModule {

    @Provides
    fun baseUrl(): String = BASE_URL

    @Provides
    fun converterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun okhttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    fun retrofit(baseUrl: String, client: OkHttpClient, converterFactory: GsonConverterFactory): Retrofit =
            Retrofit.Builder().apply {
                client(client)
                baseUrl(baseUrl)
                addConverterFactory(converterFactory)
            }.build()

    @Provides
    fun apiService(retrofit: Retrofit): MovieApiService = retrofit.create(MovieApiService::class.java)
}