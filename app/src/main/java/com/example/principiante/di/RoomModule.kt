package com.example.principiante.di

import android.content.Context
import androidx.room.Room
import com.example.principiante.data.database.VariableDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val VARIABLE_DATABASE_NAME = "variable_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context : Context) =
        Room.databaseBuilder(context,VariableDatabase::class.java, VARIABLE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideVariableDao(db :  VariableDatabase) = db.getVariableDao()
}