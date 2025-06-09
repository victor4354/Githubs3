package com.example.githubs3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.githubs3.databinding.FragmentWeatherBinding
import com.example.githubs3.viewModel.WeatherFragmentViewModel

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WeatherFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observador del clima
        viewModel.weatherData.observe(viewLifecycleOwner, Observer { weather ->
            binding.textViewWeather.text =
                "En ${weather.location.name}, la temperatura es ${weather.current.temp_c} °C"
        })

        // Llama a la API para obtener el clima
        viewModel.fetchWeather("04037100b3c64e9b90c113338250806", " 19° 24' N")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
