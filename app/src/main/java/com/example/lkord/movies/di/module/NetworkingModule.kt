package com.example.lkord.movies.di.module

import com.example.lkord.movies.BASE_URL
import com.example.lkord.movies.api.MovieApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@Singleton
class NetworkingModule {

    @Provides
    fun baseUrl(): String = BASE_URL

    @Provides
    fun converterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()


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