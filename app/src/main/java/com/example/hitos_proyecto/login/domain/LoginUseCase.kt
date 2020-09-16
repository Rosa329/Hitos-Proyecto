package com.example.hitos_proyecto.login.domain

import com.example.hitos_proyecto.login.domain.LoginRepository

class LoginUseCase (
    private val repository: LoginRepository
) {
    suspend fun execute(email: String, contrasena: String) = repository.doLogin(email, contrasena)
}