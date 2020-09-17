package com.example.hitos_proyecto.listaProductos.domain

import com.example.hitos_proyecto.listaProductos.domain.model.ListaProductos

interface ProductosRepository {
    suspend fun obtenerProductos(): ListaProductos
}