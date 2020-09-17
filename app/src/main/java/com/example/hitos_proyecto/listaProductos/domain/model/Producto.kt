package com.example.hitos_proyecto.listaProductos.domain.model

import com.example.hitos_proyecto.listaProductos.domain.model.Detalle


data class Producto(
    var id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Detalle,
    val location: Detalle,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)