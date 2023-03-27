package com.example.principiante.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.principiante.domain.model.Variable

@Entity(tableName = "variable_table")
data class VariableEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")val id : Int = 0,
    @ColumnInfo("valor")val valor :String,
    @ColumnInfo("descrip") val descrip : String)

fun Variable.toDatabase() = VariableEntity(valor = valor, descrip = descrip)