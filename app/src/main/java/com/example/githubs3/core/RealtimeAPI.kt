package com.example.githubs3.core

import com.example.githubs3.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RealtimeAPI {

    @GET("current.json") //Endpoint del clima
    suspend fun getWeatherInfo(
        @Query("key") apiKey: String, //Clave de API que te da weatherapi.com.
        @Query("q") coordinates: String //Coordenada que quieres buscar.
    ): Response<Weather> //Respuesta

}