package com.example.principiante.domain.model

import com.example.principiante.data.database.entities.VariableEntity
import com.example.principiante.data.model.VariableModel

data class Variable (val valor:String, val descrip:String)

fun VariableModel.toDomain() = Variable(valor,descrip)
fun VariableEntity.toDomain() = Variable(valor,descrip)