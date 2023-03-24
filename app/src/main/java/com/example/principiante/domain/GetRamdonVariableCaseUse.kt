package com.example.principiante.domain

import com.example.principiante.data.model.VariableModel
import com.example.principiante.data.model.VariableProvider

class GetRamdonVariableCaseUse {

     operator fun invoke(): VariableModel?{
         val variables = VariableProvider.variables

         if (!variables.isNullOrEmpty()){
             val randomVariable = (variables.indices).random()
             return variables[randomVariable]
         }
         return null
     }
}