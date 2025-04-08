package com.example.githubs3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubs3.databinding.ActivityMainFlowBinding // Importación corregida

class MainFlowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Esta actividad puede permanecer vacía según las especificaciones
    }
}