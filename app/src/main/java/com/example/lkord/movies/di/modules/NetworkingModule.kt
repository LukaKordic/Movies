package com.example.lkord.movies.di.modules

import com.example.lkord.movies.data.network.MovieAPI
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://api.themoviedb.org/3/"

@Module
@Singleton
class NetworkingModule {

    @Provides
    fun baseUrl(): String = BASE_URL

    @Provides
    fun converterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

    @Provides
    fun okhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    fun rxJavaAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()


    @Provides
    fun retrofit(baseUrl: String, client: OkHttpClient, converterFactory: GsonConverterFactory, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit =
            Retrofit.Builder().apply {
                client(client)
                baseUrl(baseUrl)
                addConverterFactory(converterFactory)
                addCallAdapterFactory(rxJava2CallAdapterFactory)
            }.build()

    @Provides
    fun apiService(retrofit: Retrofit): MovieAPI = retrofit.create(MovieAPI::class.java)
}
