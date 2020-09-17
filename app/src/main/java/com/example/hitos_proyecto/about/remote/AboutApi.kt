package com.example.hitos_proyecto.about.remote

import com.example.hitos_proyecto.about.model.AboutModel
import retrofit2.http.GET

interface AboutApi {
    @GET("about")
    suspend fun obtainAbout(): AboutModel
}