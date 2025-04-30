package com.example.githubs3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.githubs3.data.models.WeatherResponse
import com.example.githubs3.databinding.FragmentWeatherBinding
import com.example.githubs3.ui.interfaces.LoaderController
import com.example.githubs3.ui.viewmodels.WeatherViewModel

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = checkNotNull(_binding) {
        "Binding is null. Did you call onCreateView()?"
    }

    // Usar viewModels() delegado para obtener la instancia del ViewModel
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        // Iniciar la carga de datos del clima
        viewModel.getWeatherData()
    }

    private fun setupObservers() {
        // Observar los cambios en los datos del clima
        viewModel.weatherData.observe(viewLifecycleOwner) { weatherData ->
            updateUI(weatherData)
        }

        // Observar el estado de carga para mostrar/ocultar el loader
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                (activity as? LoaderController)?.showLoader()
            } else {
                (activity as? LoaderController)?.hideLoader()
            }
        }

        // Observar errores (opcional)
        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            // Mostrar mensaje de error si es necesario
            errorMessage?.let {
                // Puedes implementar una lógica para mostrar errores
                // Por ejemplo, usando un Toast o un Snackbar
            }
        }
    }

    private fun updateUI(weatherData: WeatherResponse) {
        with(binding) {
            tvCity.text = weatherData.location.name
            tvTemperature.text = "${weatherData.current.tempC}°C"
            tvWeatherCondition.text = weatherData.current.condition.text
            tvHumidity.text = "Humedad: ${weatherData.current.humidity}%"
            tvWindSpeed.text = "Viento: ${weatherData.current.windKph} km/h"

            // Cargar la imagen del clima usando Glide
            Glide.with(requireContext())
                .load("https:${weatherData.current.condition.icon}")
                .into(ivWeatherIcon)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}