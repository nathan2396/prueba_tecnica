package com.example.pruebatecnica.mvvm.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VMFactory<UC>(private val useCaseClass:UC): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        modelClass.getConstructor(useCaseClass!!::class.java)
            .newInstance(useCaseClass)
}