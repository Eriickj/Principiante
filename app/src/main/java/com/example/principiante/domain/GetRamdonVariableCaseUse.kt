package com.example.principiante.domain

import com.example.principiante.data.model.VariableModel
import com.example.principiante.data.model.VariableProvider
import javax.inject.Inject

class GetRamdonVariableCaseUse @Inject constructor(
    private val variableProvider: VariableProvider
){

     operator fun invoke(): VariableModel?{
         val variables = variableProvider.variables

         if (!variables.isNullOrEmpty()){
             val randomVariable = (variables.indices).random()
             return variables[randomVariable]
         }
         return null
     }
}