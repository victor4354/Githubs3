package com.example.githubs3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.githubs3.R
import com.google.android.material.button.MaterialButton

class RestorePasswordFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restore_password, container, false)

        view.findViewById<MaterialButton>(R.id.buttonRestore).setOnClickListener {
            // Usando el ID de acción correcto definido en nav_graph.xml
            findNavController().navigate(R.id.action_password_reset_to_login)
            // O alternativamente:
            // findNavController().navigateUp()
        }

        return view
    }
}