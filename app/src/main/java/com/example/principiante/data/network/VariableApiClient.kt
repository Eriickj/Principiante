package com.example.principiante.data.network

import com.example.principiante.data.model.VariableModel
import retrofit2.Response
import retrofit2.http.GET

interface VariableApiClient {
    @GET("numeros")
    suspend fun getAllVariables():Response<List<VariableModel>>

}