package com.example.githubs3.data.api

import com.example.githubs3.data.api.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Cliente de Retrofit para realizar llamadas a la API
 */
object RetrofitClient {
    private const val BASE_URL = "https://api.weatherapi.com/"

    /**
     * Instancia de Retrofit inicializada perezosamente
     */
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Instancia de la API del clima
     */
    val weatherApi: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }
}