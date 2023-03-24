package com.example.principiante.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://private-d57c3-numeros.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}