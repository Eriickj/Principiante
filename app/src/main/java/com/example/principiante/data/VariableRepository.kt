package com.example.principiante.data

import android.widget.Toast
import com.example.principiante.data.model.VariableModel
import com.example.principiante.data.model.VariableProvider
import com.example.principiante.data.network.VariableService
import javax.inject.Inject

class VariableRepository @Inject constructor(
    private val api: VariableService,
    private val variableProvider : VariableProvider
) {

    suspend fun getAllVariables(): List<VariableModel> {
        val response = api.getVariables()

        variableProvider.variables = response
        return response
    }
}