package com.example.hitos_proyecto.listaProductos.data.remote

import com.example.hitos_proyecto.listaProductos.domain.ProductosRepository
import com.example.hitos_proyecto.listaProductos.domain.model.Productos

class RemoteProductosRepository (
    private val apiProductos: ApiProductos,
    private val productosMapper: ProductosMapper
): ProductosRepository{

    override suspend fun obtenerProductos(): Productos {
        val productos = apiProductos.obtenerProducto()
        return productosMapper.mapToEntityProductos(productos)
    }
}