package com.example.githubs3.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.githubs3.data.models.WeatherResponse
import com.example.githubs3.data.repository.WeatherRepository
import com.example.githubs3.utils.LocationHelper
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val weatherRepository = WeatherRepository()
    private val locationHelper = LocationHelper(application)

    // LiveData para los datos del clima
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> = _weatherData

    // LiveData para el estado de carga
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // LiveData para manejar errores
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    // API Key para WeatherAPI (deberías guardar esto en un lugar más seguro en una app real)
    private val apiKey = "TU_API_KEY" // Reemplazar con tu API key

    /**
     * Obtiene los datos del clima usando la ubicación del usuario
     */
    fun getWeatherData() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                // Intentar obtener la ubicación del usuario
                val coordinates = getUserLocation()
                // Si falla, usar coordenadas predeterminadas
                    ?: "19.4326,-99.1332" // Ciudad de México como ubicación por defecto

                Log.d(TAG, "Obteniendo datos del clima para: $coordinates")

                // Llamar al repositorio para obtener datos del clima
                val response = weatherRepository.getWeatherInfo(apiKey, coordinates)
                _weatherData.value = response

                Log.d(TAG, "Datos del clima obtenidos: ${response.location.name}, ${response.current.tempC}°C")
            } catch (e: Exception) {
                Log.e(TAG, "Error al obtener datos del clima", e)
                _error.value = "Error al obtener datos del clima: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Obtiene la ubicación actual del usuario
     */
    private suspend fun getUserLocation(): String? {
        return try {
            locationHelper.getCurrentLocation()
        } catch (e: Exception) {
            Log.e(TAG, "Error al obtener la ubicación", e)
            null
        }
    }

    companion object {
        private const val TAG = "WeatherViewModel"
    }
}