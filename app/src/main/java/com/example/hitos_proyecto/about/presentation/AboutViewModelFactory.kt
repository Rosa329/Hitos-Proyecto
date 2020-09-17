package com.example.hitos_proyecto.about.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hitos_proyecto.about.domain.ObtainAboutUseCase

class AboutViewModelFactory (
    private val aboutUseCase: ObtainAboutUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtainAboutUseCase::class.java)
            .newInstance(aboutUseCase)
    }
}
