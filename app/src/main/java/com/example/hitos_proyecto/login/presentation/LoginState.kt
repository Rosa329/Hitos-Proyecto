package com.example.hitos_proyecto.login.presentation

import com.example.hitos_proyecto.login.domain.model.LoginUsuario

sealed class LoginState(
    open val result: LoginUsuario? = null,
    open val error: Throwable? = null
) {
    object LoadingLogin : LoginState()
    data class SuccessLogin(override val result: LoginUsuario?) : LoginState(result = result)
    data class Error(override val error: Throwable?) : LoginState(error = error)
    object InvalidUser : LoginState()
}