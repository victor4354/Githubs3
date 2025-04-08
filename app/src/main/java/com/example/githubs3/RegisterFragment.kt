package com.example.githubs3
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        // Configurar navegación para el botón de registro
        view.findViewById<MaterialButton>(R.id.buttonRegister).setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_personalInfoFragment)
        }

        return view
    }
}