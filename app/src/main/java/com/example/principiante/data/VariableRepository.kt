package com.example.principiante.data

import com.example.principiante.data.database.dao.VariableDao
import com.example.principiante.data.database.entities.VariableEntity
import com.example.principiante.data.network.VariableService
import com.example.principiante.domain.model.Variable
import com.example.principiante.domain.model.toDomain
import javax.inject.Inject

class VariableRepository @Inject constructor(
    private val api: VariableService,
    private val variableDao: VariableDao
) {

    suspend fun getAllVariablesFromApi(): List<Variable> {
        val response = api.getVariables()
        return response.map { it.toDomain() }
    }

    suspend fun getAllVariblesFromDataBase():List<Variable>{
        val response =  variableDao.getAllVariables()
        return response.map { it.toDomain() }
    }

    suspend fun insertVariables(variables : List<VariableEntity>){
        variableDao.insertAll(variables)
    }

    suspend fun clearVariables() {
        variableDao.deleteAllVariables()
    }
}