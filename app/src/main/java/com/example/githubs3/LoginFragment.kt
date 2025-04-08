package com.example.loginflowapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Configurar navegación para el botón de registro
        view.findViewById<TextView>(R.id.textRegister).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        // Configurar navegación para restablecer contraseña
        view.findViewById<TextView>(R.id.textForgotPassword).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_restorePasswordFragment)
        }

        // Configurar navegación para el botón de login
        view.findViewById<MaterialButton>(R.id.buttonLogin).setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_loaderFragment)
        }

        return view
    }
}