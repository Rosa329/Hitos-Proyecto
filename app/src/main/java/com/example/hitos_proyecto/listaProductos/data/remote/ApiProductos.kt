package com.example.hitos_proyecto.listaProductos.data.remote

import retrofit2.http.GET

interface ApiProductos {

    @GET("character")
    suspend fun obtenerProducto(): ProductoModel
}