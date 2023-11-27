package com.example.goldapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.goldapp.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}