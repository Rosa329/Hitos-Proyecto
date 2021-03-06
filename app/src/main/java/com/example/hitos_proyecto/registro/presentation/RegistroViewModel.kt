package com.example.hitos_proyecto.registro.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hitos_proyecto.registro.domain.RegistroUseCase
import com.example.hitos_proyecto.registro.domain.model.RegistroUsuario
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import kotlinx.coroutines.launch

class RegistroViewModel (
    private val registroUseCase: RegistroUseCase
) : ViewModel() {

    private val liveData = MutableLiveData<RegistroState>()

    fun getLiveData() = liveData

    fun registrarUsuario(registroUsuario: RegistroUsuario) {
        liveData.postValue(RegistroState.LoadingRegistroState)
        viewModelScope.launch {
            try {
                val result = registroUseCase.execute(registroUsuario)
                handleResult(result)
            } catch (exception: Exception) {
                handleError(exception)
            }
        }
    }

    private fun handleError(exception: Exception) {
        if (exception is FirebaseAuthUserCollisionException) {
            liveData.postValue(RegistroState.EmailAlreadyExist)
        } else {
            liveData.postValue(RegistroState.ErrorRegistroState(exception))
        }
    }

    private fun handleResult(result: Boolean) {
        if (result) {
            liveData.postValue(RegistroState.SuccessRegistroState)
        } else {
            liveData.postValue(RegistroState.EmailAlreadyExist)
        }
    }
}