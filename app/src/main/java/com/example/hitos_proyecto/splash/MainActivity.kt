package com.example.hitos_proyecto.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hitos_proyecto.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)// se que esto no va pero es para demostrar que está
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}