package com.example.hitos_proyecto.listaProductos.data.remote

import com.example.hitos_proyecto.listaProductos.domain.model.InfoProducto
import com.example.hitos_proyecto.listaProductos.domain.model.Productos

class ProductosMapper{

    fun mapToEntityProductos(productoModel: List<InfoProductoModel>):Productos{
        productoModel.apply {

           return Productos(productoModel.map {
               InfoProducto(it.id, it.nombre, it.precio, it.tamaño,it.imagen)
           })
        }
    }
}