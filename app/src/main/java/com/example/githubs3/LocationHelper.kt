package com.example.githubs3.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Clase auxiliar para obtener la ubicación del usuario de forma segura.
 */
class LocationHelper(private val context: Context) {
    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    companion object {
        private const val TAG = "LocationHelper"
    }

    /**
     * Obtiene la ubicación actual del usuario.
     * @return Coordenadas en formato "latitud,longitud" o null si hay errores.
     */
    suspend fun getCurrentLocation(): String? = suspendCoroutine { continuation ->
        if (!hasLocationPermissions()) {
            Log.w(TAG, "Permisos de ubicación no concedidos")
            continuation.resume(null)
            return@suspendCoroutine
        }

        try {
            // Verificación explícita de permisos antes de acceder a la ubicación
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // No tenemos permisos, no podemos continuar
                Log.w(TAG, "Permisos de ubicación no disponibles")
                continuation.resume(null)
                return@suspendCoroutine
            }

            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    handleLocationResult(location, continuation)
                }
                .addOnFailureListener { e ->
                    Log.e(TAG, "Error en FusedLocationProviderClient", e)
                    continuation.resume(null)
                }
        } catch (se: SecurityException) {
            // Captura explícita de SecurityException
            Log.e(TAG, "SecurityException al acceder a la ubicación", se)
            continuation.resume(null)
        }
    }

    /**
     * Verifica si los permisos de ubicación están concedidos.
     */
    private fun hasLocationPermissions(): Boolean {
        return ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Procesa el resultado de la ubicación.
     */
    private fun handleLocationResult(location: Location?, continuation: kotlin.coroutines.Continuation<String?>) {
        location?.let {
            val coordinates = "${it.latitude},${it.longitude}"
            Log.d(TAG, "Ubicación obtenida: $coordinates")
            continuation.resume(coordinates)
        } ?: run {
            Log.w(TAG, "Ubicación nula: GPS desactivado o sin datos recientes")
            continuation.resume(null)
        }
    }
}