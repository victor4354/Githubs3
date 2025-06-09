package com.example.githubs3.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    fun getRetrofit(): Retrofit {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout( 50, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com/v1")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}