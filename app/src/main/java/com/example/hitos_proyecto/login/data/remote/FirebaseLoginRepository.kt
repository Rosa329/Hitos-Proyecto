package com.example.hitos_proyecto.login.data.remote

import com.example.hitos_proyecto.login.domain.LoginRepository
import com.example.hitos_proyecto.login.domain.model.LoginUsuario
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class FirebaseLoginRepository (
    private val firebaseAuth: FirebaseAuth
): LoginRepository {

    override suspend fun ingresarUsuario(email: String, contrasena: String): LoginUsuario {
        firebaseAuth
            .signInWithEmailAndPassword(email, contrasena)
            .await()
        val user = firebaseAuth.currentUser
        return LoginUsuario(user?.displayName?: "", user?.email?:"")
    }


}