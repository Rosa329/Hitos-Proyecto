package com.example.hitos_proyecto.listaProductos.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetalleModel(
    val name: String? = null,
    val url: String? = null
)