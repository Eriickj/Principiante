package com.example.principiante.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.principiante.data.database.entities.VariableEntity

@Dao
interface VariableDao {

    @Query("SELECT * FROM variable_table ORDER BY valor")
    suspend fun getAllVariables():List<VariableEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(variable:List<VariableEntity>)

    @Query("DELETE FROM variable_table")
    suspend fun deleteAllVariables()
}