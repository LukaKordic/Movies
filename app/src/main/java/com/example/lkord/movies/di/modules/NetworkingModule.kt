package com.example.lkord.movies.di.modules

import com.example.lkord.movies.network.MovieAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun apiService(retrofit: Retrofit): MovieAPI = retrofit.create(MovieAPI::class.java)
}
