package com.example.githubs3.ui.interfaces

/**
 * Interfaz para controlar la visibilidad del loader desde los fragmentos
 */
interface LoaderController {
    /**
     * Muestra el loader
     */
    fun showLoader()

    /**
     * Oculta el loader
     */
    fun hideLoader()
}