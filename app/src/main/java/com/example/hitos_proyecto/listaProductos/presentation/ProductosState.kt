package com.example.hitos_proyecto.listaProductos.presentation

import com.example.hitos_proyecto.listaProductos.domain.model.InfoProducto
import com.example.hitos_proyecto.listaProductos.domain.model.Productos

open class ProductosState(
    open val resultProductos: Productos? = null,
    open val error: Throwable? = null
) {
    object CargandoProductos : ProductosState()
    data class ObtenerTodosLosProductos(override val resultProductos: Productos) :
        ProductosState(resultProductos = resultProductos)

    //  data class ObtenerDetalleDelProducto(override val resultDetalleDelProducto: InfoProducto?): ProductosState(resultDetalleProducto = resultDetalleProducto)
    data class Error(override val error: Throwable) : ProductosState(error = error)
}