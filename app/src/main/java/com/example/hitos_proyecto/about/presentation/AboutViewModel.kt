package com.example.hitos_proyecto.about.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hitos_proyecto.about.domain.About
import com.example.hitos_proyecto.about.domain.ObtainAboutUseCase
import kotlinx.coroutines.launch

class AboutViewModel (
    private val obtainAboutUseCase: ObtainAboutUseCase
): ViewModel(){
    private val liveData= MutableLiveData<About?>()
    fun getLiveData()= liveData

    fun obtenerAbout(){
        viewModelScope.launch {
            try {
                val result= obtainAboutUseCase.excecute()
                liveData.postValue(result)
            } catch (e: Exception){
                liveData.postValue(null)            }
        }
    }
}