package com.example.hitos_proyecto.registro.domain

import com.example.hitos_proyecto.registro.domain.model.RegistroUsuario

class RegistroUseCase (
    private val repository: RegistroRepository
) {
    suspend fun execute(registroUsuario: RegistroUsuario) = repository.registrar(registroUsuario)
}