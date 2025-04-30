package com.example.githubs3.data.api

import com.example.githubs3.data.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interfaz que define los endpoints de la API de Weather
 */
interface WeatherApi {
    /**
     * Obtiene la información del clima en tiempo real
     *
     * @param apiKey La clave API de WeatherAPI
     * @param coordinates Las coordenadas en formato "latitud,longitud"
     * @return La respuesta con los datos del clima
     */
    @GET("v1/current.json")
    suspend fun getWeatherInfo(
        @Query("key") apiKey: String,
        @Query("q") coordinates: String
    ): WeatherResponse
}