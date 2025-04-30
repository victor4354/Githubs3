package com.example.githubs3.data.repository

import com.example.githubs3.data.api.RetrofitClient
import com.example.githubs3.data.models.WeatherResponse

/**
 * Repositorio que maneja las operaciones relacionadas con el clima
 */
class WeatherRepository {
    // Obtener la instancia de la API desde RetrofitClient
    private val weatherApi = RetrofitClient.weatherApi

    /**
     * Obtiene la información del clima para las coordenadas especificadas
     *
     * @param apiKey La clave API de WeatherAPI
     * @param coordinates Las coordenadas en formato "latitud,longitud"
     * @return La respuesta con los datos del clima
     */
    suspend fun getWeatherInfo(apiKey: String, coordinates: String): WeatherResponse {
        return weatherApi.getWeatherInfo(apiKey, coordinates)
    }
}