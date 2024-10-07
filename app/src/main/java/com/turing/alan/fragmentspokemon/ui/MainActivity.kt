package com.turing.alan.fragmentspokemon.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.turing.alan.fragmentspokemon.R

class MainActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }
}