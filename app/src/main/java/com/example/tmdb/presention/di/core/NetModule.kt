package com.example.tmdb.presention.di.core

import com.example.tmdb.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule(private val baseurl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor= HttpLoggingInterceptor().apply {
            this.level= HttpLoggingInterceptor.Level.BODY

        }
        val client= OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(20, TimeUnit.SECONDS)
//                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTMBservice(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}