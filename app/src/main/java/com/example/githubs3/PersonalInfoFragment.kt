package com.example.loginflowapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class PersonalInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info, container, false)

        val checkBoxReferralCode = view.findViewById<CheckBox>(R.id.checkBoxReferralCode)
        val buttonContinue = view.findViewById<MaterialButton>(R.id.buttonContinue)

        buttonContinue.setOnClickListener {
            if (checkBoxReferralCode.isChecked) {
                findNavController().navigate(R.id.action_personalInfoFragment_to_personalInfoVariantFragment)
            } else {
                findNavController().navigate(R.id.action_personalInfoFragment_to_loaderFragment)
            }
        }

        return view
    }
}