package com.example.githubs3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.PatternsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.githubs3.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.textRegister.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }

        binding.textForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_password_reset)
        }

        binding.buttonLogin.setOnClickListener {
            if (validateForm()) {
                showLoader()
                performLogin()
            }
        }
    }

    private fun validateForm(): Boolean {
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()
        var isValid = true

        // Validación de email
        if (email.isEmpty() || !PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.textInputLayoutEmail.error = "Correo electrónico inválido"
            isValid = false
        } else {
            binding.textInputLayoutEmail.error = null
        }

        // Validación de contraseña
        if (password.isEmpty() || password.length < 6) {
            binding.textInputLayoutPassword.error = "La contraseña debe tener al menos 6 caracteres"
            isValid = false
        } else {
            binding.textInputLayoutPassword.error = null
        }

        return isValid
    }

    private fun showLoader() {
        findNavController().navigate(R.id.action_login_to_loader)
    }

    private fun performLogin() {
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()

        FirebaseAuthManager.loginUser(
            email = email,
            password = password,
            onSuccess = {

                findNavController().navigate(R.id.mainFlowActivity)
            },
            onError = { errorMessage ->
                findNavController().popBackStack() // Regresa al LoginFragment
                showError(errorMessage)
            }
        )
    }

    private fun showError(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}