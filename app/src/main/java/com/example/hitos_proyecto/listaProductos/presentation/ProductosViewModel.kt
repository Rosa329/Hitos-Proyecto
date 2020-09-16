package com.example.hitos_proyecto.listaProductos.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hitos_proyecto.listaProductos.domain.ObtenerProductosUseCase
import com.example.hitos_proyecto.listaProductos.domain.model.Productos
import kotlinx.coroutines.launch

class ProductosViewModel (
    private val obtenerProductosUseCase: ObtenerProductosUseCase
): ViewModel(){
    private val liveData= MutableLiveData<ProductosState>()

    fun getLiveData()= liveData

    fun obtenerProductos(){
        liveData.postValue(ProductosState.CargandoProductos)
        viewModelScope.launch {
            try{
                val result = obtenerProductosUseCase.execute()
                handleResult(result)
            } catch  ( exception: Exception){
                handleError(exception)
            }
        }
    }

    private fun handleError(exception: Exception) {
        liveData.postValue(ProductosState.Error(exception))


    }

    private fun handleResult(result: Productos) {
        liveData.postValue(ProductosState.ObtenerTodosLosProductos(result))

    }
}