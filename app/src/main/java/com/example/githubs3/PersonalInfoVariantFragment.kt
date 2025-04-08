package com.example.loginflowapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class PersonalInfoVariantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info_variant, container, false)

        view.findViewById<MaterialButton>(R.id.buttonContinue).setOnClickListener {
            findNavController().navigate(R.id.action_personalInfoVariantFragment_to_loaderFragment)
        }

        return view
    }
}