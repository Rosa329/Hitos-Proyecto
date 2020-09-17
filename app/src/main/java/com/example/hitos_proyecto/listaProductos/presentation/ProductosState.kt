package com.example.hitos_proyecto.listaProductos.presentation

import com.example.hitos_proyecto.listaProductos.domain.model.ListaProductos


open class ProductosState(
    open val resultProductos: ListaProductos? = null,
    //open val resultDetalleProducto: DetalleProducto? = null,
    open val error: Throwable? = null
) {
    object CargandoProductos : ProductosState()
    data class ObtenerTodosLosProductos(override val resultProductos: ListaProductos?) :
        ProductosState(resultProductos = resultProductos)
    //data class ObtenerDetalleDelProducto(override val resultDetalleProducto: DetalleProducto?): ProductosState(resultDetalleProducto = resultDetalleProducto)
    data class Error(override val error: Throwable?) : ProductosState(error = error)
}