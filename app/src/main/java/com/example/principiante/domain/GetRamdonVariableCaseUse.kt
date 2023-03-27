package com.example.principiante.domain

import com.example.principiante.data.VariableRepository
import com.example.principiante.data.model.VariableModel
import com.example.principiante.domain.model.Variable
import javax.inject.Inject

class GetRamdonVariableCaseUse @Inject constructor(
    private val repository: VariableRepository
){

     suspend operator fun invoke(): Variable?{
         val variables = repository.getAllVariblesFromDataBase()

         if (!variables.isNullOrEmpty()){
             val randomVariable = (variables.indices).random()
             return variables[randomVariable]
         }
         return null
     }
}