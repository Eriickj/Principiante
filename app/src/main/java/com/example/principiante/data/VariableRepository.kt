package com.example.principiante.data

import android.widget.Toast
import com.example.principiante.data.model.VariableModel
import com.example.principiante.data.model.VariableProvider
import com.example.principiante.data.network.VariableService

class VariableRepository {

    private  val api = VariableService()

    suspend fun getAllVariables():List<VariableModel>{
        val response = api.getVariables()

        if (response.isNullOrEmpty()) {
            println("Devuelve null en VariableRepository")
        }else{
            println(response.size)
        }
        VariableProvider.variables = response
        return response
    }
}