package com.example.hitos_proyecto.listaProductos.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoProductoModel(
    val id : Int?=null,
    val nombre: String?=null,
    val precio: Int?= null,
    val tamaño: String? = null,
    val imagen : String?=null
) {
    fun obtenerProductos() {
        TODO("Not yet implemented")
    }


}