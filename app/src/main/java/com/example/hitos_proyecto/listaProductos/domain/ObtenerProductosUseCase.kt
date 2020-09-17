package com.example.hitos_proyecto.listaProductos.domain

import com.example.hitos_proyecto.listaProductos.domain.model.ListaProductos

class ObtenerProductosUseCase(private val repository: ProductosRepository) {
    suspend fun execute(): ListaProductos = repository.obtenerProductos()
}