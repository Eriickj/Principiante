package com.example.principiante.domain

import com.example.principiante.data.VariableRepository
import com.example.principiante.data.model.VariableModel
import javax.inject.Inject

class GetVariableUseCase @Inject constructor(
    private val repository : VariableRepository
) {
    
    suspend operator fun invoke(): List<VariableModel>? = repository.getAllVariables()

}