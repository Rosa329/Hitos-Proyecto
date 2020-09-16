package com.example.hitos_proyecto.listaProductos.data.remote

import retrofit2.http.GET

interface ApiProductos {

    @GET("generation")
    suspend fun obtenerProducto (): List<InfoProductoModel>
}