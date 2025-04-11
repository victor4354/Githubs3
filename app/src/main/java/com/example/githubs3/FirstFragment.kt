package com.example.githubs3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.githubs3.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = checkNotNull(_binding) {
        "Binding is null. Did you call onCreateView()?"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        // Asegúrate de devolver binding.root como View, no como NestedScrollView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.buttonFirst.setOnClickListener {
            navigateToSecondFragment()
        }
    }

    private fun navigateToSecondFragment() {
        // Navegación usando Safe Args (ya que tienes el plugin configurado)
        val directions = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
        findNavController().navigate(directions)

        // Alternativa si continúas teniendo problemas con Safe Args:
        // findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}