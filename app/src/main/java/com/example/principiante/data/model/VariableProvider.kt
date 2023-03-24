package com.example.principiante.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VariableProvider @Inject constructor() {

    var variables: List<VariableModel> = emptyList()

}