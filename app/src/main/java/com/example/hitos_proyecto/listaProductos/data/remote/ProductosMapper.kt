package com.example.hitos_proyecto.listaProductos.data.remote

import com.example.hitos_proyecto.listaProductos.data.remote.DetalleModel
import com.example.hitos_proyecto.listaProductos.domain.model.Detalle
import com.example.hitos_proyecto.listaProductos.domain.model.ListaProductos
import com.example.hitos_proyecto.listaProductos.domain.model.Producto
import java.util.ArrayList

class ProductosMapper {

    fun mapEntityToDomainList(productoModel: ProductoModel): ListaProductos {
        val listaProducto: MutableList<Producto> = ArrayList()
        listaProducto.add(
            mapEntityToDomain(
                productoModel
            )
        )
        return ListaProductos(listaProducto)
    }

    fun mapEntityToDomain(productoModel: ProductoModel): Producto {
        productoModel.apply {
            return Producto(
                id ?: 0,
                name ?: "",
                status ?: "",
                species ?: "",
                type ?: "",
                gender ?: "",
                mapEntityToDomainDetalle(origin),
                mapEntityToDomainDetalle(location),
                image ?: "",
                episode ?: emptyList(),
                url ?: "",
                created ?: ""
            )
        }
    }

    fun mapEntityToDomainDetalle(detalleModel: DetalleModel): Detalle {
        detalleModel.apply{
            return Detalle(
                name?: "",
                url?: ""
            )
        }
    }
}