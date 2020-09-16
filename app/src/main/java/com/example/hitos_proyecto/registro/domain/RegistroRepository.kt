package com.example.hitos_proyecto.registro.domain

import com.example.hitos_proyecto.registro.domain.model.RegistroUsuario

interface RegistroRepository {
    suspend fun registrar(registro: RegistroUsuario): Boolean
}