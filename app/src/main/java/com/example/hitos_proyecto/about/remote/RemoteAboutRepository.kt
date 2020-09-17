package com.example.hitos_proyecto.about.remote

import com.example.hitos_proyecto.about.domain.About
import com.example.hitos_proyecto.about.domain.AboutRepository

class RemoteAboutRepository (
    private val aboutApi: AboutApi,
    private val aboutDataMapper: AboutDataMapper
): AboutRepository {
    override suspend fun obtenerAbout(): About {
        return aboutDataMapper.mapToDomain(aboutApi.obtainAbout())
    }
}