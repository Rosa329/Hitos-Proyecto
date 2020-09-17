package com.example.hitos_proyecto.listaProductos.data.remote

import com.example.hitos_proyecto.listaProductos.domain.ProductosRepository
import com.example.hitos_proyecto.listaProductos.domain.model.ListaProductos

class RemoteProductosRepository (
    private val apiProductos: ApiProductos,
    private val productosMapper: ProductosMapper
): ProductosRepository {

    override suspend fun obtenerProductos(): ListaProductos {
        val productos = apiProductos.obtenerProducto()
        return productosMapper.mapEntityToDomainList(productos)
    }
}