package com.example.pruebatecnica

import android.os.Bundle
import com.example.pruebatecnica.databinding.ActivityMainBinding
import com.example.pruebatecnica.mvvm.common.GenericActivity


private lateinit var binding: ActivityMainBinding

class MainActivity : GenericActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
