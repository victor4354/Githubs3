package com.example.githubs3.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.githubs3.R
import com.google.android.material.button.MaterialButton

class PersonalInfoVariantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_info_variant, container, false)

        view.findViewById<MaterialButton>(R.id.buttonContinue).setOnClickListener {
            // Since there's no direct action defined in the nav graph, navigate to loader directly
            findNavController().navigate(R.id.loaderFragment)

            // Alternative: If you prefer to use navigateUp() to go back
            // findNavController().navigateUp()
        }

        return view
    }
}