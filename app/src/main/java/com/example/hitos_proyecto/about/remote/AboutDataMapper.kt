package com.example.hitos_proyecto.about.remote

import com.example.hitos_proyecto.about.domain.About
import com.example.hitos_proyecto.about.model.AboutModel

class AboutDataMapper {
    fun  mapToDomain(aboutModel: AboutModel): About{
aboutModel.apply {
    return About(version, name, author, company)
}
    }
}