package com.example.githubs3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubs3.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Correcto si el layout existe
    }
}