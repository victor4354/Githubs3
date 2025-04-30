package com.example.githubs3

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.example.githubs3.databinding.ActivityMainBinding
import com.example.githubs3.ui.interfaces.LoaderController
import com.example.githubs3.utils.LocationHelper
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), LoaderController {

    private lateinit var binding: ActivityMainBinding
    private lateinit var lottieAnimationView: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLoader()
        checkLocationPermissions()
    }

    /**
     * Configura el loader con animación Lottie
     */
    private fun setupLoader() {
        lottieAnimationView = binding.lottieAnimationView
        lottieAnimationView.setAnimation("loading_animation.json") // Asegúrate de tener el archivo en res/raw
        lottieAnimationView.speed = 1.0f
        lottieAnimationView.repeatCount = LottieDrawable.INFINITE
    }

    /**
     * Verifica y solicita permisos de ubicación
     */
    private fun checkLocationPermissions() {
        if (hasLocationPermissions()) {
            obtenerUbicacion()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    /**
     * Verifica si los permisos están concedidos
     */
    private fun hasLocationPermissions(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Maneja la respuesta de los permisos
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_LOCATION_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                    obtenerUbicacion()
                } else {
                    Toast.makeText(
                        this,
                        "Los permisos de ubicación son necesarios",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    /**
     * Obtiene la ubicación usando LocationHelper
     */
    private fun obtenerUbicacion() {
        lifecycleScope.launch {
            showLoader()
            val locationHelper = LocationHelper(this@MainActivity)
            val coordinates = locationHelper.getCurrentLocation()
            coordinates?.let {
                // Usar las coordenadas (ej: enviar a un ViewModel)
                Toast.makeText(
                    this@MainActivity,
                    "Ubicación: $it",
                    Toast.LENGTH_SHORT
                ).show()
            }
            hideLoader()
        }
    }

    override fun showLoader() {
        binding.loaderContainer.visibility = View.VISIBLE
        lottieAnimationView.playAnimation()
    }

    override fun hideLoader() {
        lottieAnimationView.pauseAnimation()
        binding.loaderContainer.visibility = View.GONE
    }

    companion object {
        private const val REQUEST_LOCATION_PERMISSION = 100
    }
}