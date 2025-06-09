package com.example.githubs3.network

import android.util.Log
import com.example.githubs3.core.RealtimeAPI
import com.example.githubs3.core.RetrofitInstance
import com.example.githubs3.model.Weather

class WeatherRepository {
    private val retrofit = RetrofitInstance.getRetrofit().create(RealtimeAPI::class.java)

    suspend fun getWeatherInfo(apiKey: String, coordinates: String): Weather? {
        val response = retrofit.getWeatherInfo(apiKey, coordinates)
        Log.i("RESPONSE", response.body().toString())

        return response.body()
    }
}