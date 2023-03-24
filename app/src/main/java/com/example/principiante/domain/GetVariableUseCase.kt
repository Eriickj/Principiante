package com.example.principiante.domain

import com.example.principiante.data.VariableRepository
import com.example.principiante.data.model.VariableModel

class GetVariableUseCase {

    private val repository = VariableRepository()

    suspend operator fun invoke(): List<VariableModel>? = repository.getAllVariables()

}