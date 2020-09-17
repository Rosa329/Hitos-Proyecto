package com.example.hitos_proyecto.about.model

import com.google.gson.annotations.SerializedName

class AboutModel (
    val version: String,
    @SerializedName("name_app")
    val name : String,
    val author: String,
    val company:String
)