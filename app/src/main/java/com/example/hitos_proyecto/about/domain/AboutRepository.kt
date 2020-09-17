package com.example.hitos_proyecto.about.domain

interface AboutRepository {
    suspend fun obtenerAbout(): About
}