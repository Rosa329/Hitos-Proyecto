package com.example.hitos_proyecto.network.api

import com.example.hitos_proyecto.listaProductos.data.remote.ApiProductos
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitHandler{
    companion object{
        fun getRetrofit(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.apply { interceptor.level= HttpLoggingInterceptor.Level.BODY}
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val moshi= Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

           return Retrofit.Builder()
                .baseUrl("http://192.168.1.101:3000/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

        }
        fun getApiProductos(): ApiProductos {
            return getRetrofit().create(ApiProductos::class.java)
        }
    }
}