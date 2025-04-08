package com.example.loginflowapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginflowapp.databinding.ActivityMainFlowBinding

class MainFlowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}