package com.example.hitos_proyecto.listaProductos.domain

import com.example.hitos_proyecto.listaProductos.domain.model.Productos

class ObtenerProductosUseCase(private val repository: ProductosRepository) {
    suspend fun execute(): Productos= repository.obtenerProductos()

}