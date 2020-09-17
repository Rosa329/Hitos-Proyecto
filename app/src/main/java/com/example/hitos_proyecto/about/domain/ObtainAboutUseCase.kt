package com.example.hitos_proyecto.about.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ObtainAboutUseCase ( private val repository: AboutRepository){
    suspend fun excecute(): About= repository.obtenerAbout()


    }

