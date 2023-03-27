package com.example.principiante.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.principiante.data.database.dao.VariableDao
import com.example.principiante.data.database.entities.VariableEntity

@Database(entities = [VariableEntity::class], version = 1)
abstract class VariableDatabase : RoomDatabase(){

    abstract fun getVariableDao():VariableDao
}