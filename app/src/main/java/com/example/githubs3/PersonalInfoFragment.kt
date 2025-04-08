package com.example.githubs3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class PersonalInfoFragment : Fragment() { // Nombre de clase corregido

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false) // Layout corregido

        // Configurar navegación para el botón de continuar
        view.findViewById<MaterialButton>(R.id.buttonContinue).setOnClickListener {
            findNavController().navigate(R.id.action_personalInfoFragment_to_loaderFragment) // Acción corregida
        }

        return view
    }
}