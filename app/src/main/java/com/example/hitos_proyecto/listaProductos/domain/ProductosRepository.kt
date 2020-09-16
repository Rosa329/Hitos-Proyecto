package com.example.hitos_proyecto.listaProductos.domain

import com.example.hitos_proyecto.listaProductos.domain.model.Productos

interface ProductosRepository {
 suspend fun obtenerProductos():Productos

}