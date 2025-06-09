package com.example.githubs3.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.githubs3.R
import com.google.android.material.button.MaterialButton

class PersonalInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)

        // Configurar navegación para el botón de continuar
        view.findViewById<MaterialButton>(R.id.buttonContinue).setOnClickListener {
            findNavController().navigate(R.id.action_personal_info_to_loader) // ID de acción corregido
        }

        return view
    }
}