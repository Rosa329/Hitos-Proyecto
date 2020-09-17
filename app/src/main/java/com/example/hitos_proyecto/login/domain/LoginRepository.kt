package com.example.hitos_proyecto.login.domain

import com.example.hitos_proyecto.login.domain.model.LoginUsuario

interface LoginRepository {
    suspend fun ingresarUsuario(email: String, contrasena: String): LoginUsuario
}