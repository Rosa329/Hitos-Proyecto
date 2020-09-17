package com.example.hitos_proyecto.listaProductos.data.remote

import android.location.Location
import android.webkit.WebStorage
import com.squareup.moshi.JsonClass
import com.example.hitos_proyecto.listaProductos.data.remote.DetalleModel

@JsonClass(generateAdapter = true)
data class ProductoModel(
    var id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val origin: DetalleModel? = null,
    val location: DetalleModel? = null,
    val image: String? = null,
    val episode: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)
