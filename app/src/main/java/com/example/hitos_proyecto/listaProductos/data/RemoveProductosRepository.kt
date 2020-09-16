package com.example.hitos_proyecto.listaProductos.data

import com.example.hitos_proyecto.listaProductos.data.remote.ApiProductos
import com.example.hitos_proyecto.listaProductos.domain.ProductosRepository
import com.example.hitos_proyecto.listaProductos.domain.model.InfoProducto
import com.example.hitos_proyecto.listaProductos.domain.model.Productos

class RemoveProductosRepository(private val apiProductos: ApiProductos) : ProductosRepository {
    override suspend fun obtenerProductos(): Productos {
        TODO("Not yet implemented")
    }


}