package com.example.hitos_proyecto.listaProductos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hitos_proyecto.listaProductos.domain.ObtenerProductosUseCase


class ProductosViewModelFactory(
 private val obtenerUseCase: ObtenerProductosUseCase
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ObtenerProductosUseCase::class.java)
            .newInstance(obtenerUseCase)
    }
}
