package com.example.principiante.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.principiante.data.model.VariableModel
import com.example.principiante.data.model.VariableProvider
import com.example.principiante.domain.GetRamdonVariableCaseUse
import com.example.principiante.domain.GetVariableUseCase
import com.example.principiante.ui.view.MainActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VariableViewModel @Inject constructor(
    private val getVariableUseCase : GetVariableUseCase,
    private val getRamdonVariableCaseUse : GetRamdonVariableCaseUse
) : ViewModel() {


    val variableModel = MutableLiveData<VariableModel>()
    val isLoading = MutableLiveData<Boolean>()
    lateinit var context: Context

    fun onCreate(context: Context) {
        this.context = context
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getVariableUseCase()

            if (!result.isNullOrEmpty()) {
                variableModel.postValue(result[0])
                isLoading.postValue(false)

            } else {
                Toast.makeText(context, "Devuelve null en ViewModel", Toast.LENGTH_LONG).show()
            }
        }
    }


    fun ramdonVariable() {
        isLoading.postValue(true)
        val variable = getRamdonVariableCaseUse()
        if(variable!=null){
            variableModel.postValue(variable!!)
        }
        isLoading.postValue(false)
    }


}