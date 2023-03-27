package com.example.principiante.data.network

import com.example.principiante.data.model.VariableModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VariableService @Inject constructor(
    private val api : VariableApiClient
){

    suspend fun getVariables(): List<VariableModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllVariables()
            if (response.isSuccessful)
                response.body() ?: emptyList()
            else
                emptyList()

        }

    }
}