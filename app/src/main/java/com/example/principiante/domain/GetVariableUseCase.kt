package com.example.principiante.domain

import com.example.principiante.data.VariableRepository
import com.example.principiante.data.database.entities.toDatabase
import com.example.principiante.data.model.VariableModel
import com.example.principiante.domain.model.Variable
import javax.inject.Inject

class GetVariableUseCase @Inject constructor(
    private val repository : VariableRepository
) {
    
    suspend operator fun invoke(): List<Variable> {
        val variables =  repository.getAllVariablesFromApi()

        return if(variables.isNotEmpty()){
            repository.clearVariables()
            repository.insertVariables(variables.map { it.toDatabase() })
            variables
        }else{
            repository.getAllVariblesFromDataBase()
        }
    }

}