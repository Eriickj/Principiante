package com.example.principiante.data.network

import com.example.principiante.core.RetroFitHelper
import com.example.principiante.data.model.VariableModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VariableService {
    private val retrofit = RetroFitHelper.getRetrofit()

    suspend fun getVariables(): List<VariableModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(VariableApiClient::class.java).getAllVariables()
            if (response.isSuccessful) {
                if (response.body().isNullOrEmpty()) {
                    println("Devuelve null en VariableService")
                }
            }else {

            }

            response.body() ?: emptyList()
        }

    }
}