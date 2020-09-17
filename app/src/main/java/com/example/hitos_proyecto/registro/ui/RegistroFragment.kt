package com.example.hitos_proyecto.registro.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import cl.talentodigital.consultavalores.util.extentions.*
import com.example.hitos_proyecto.R
import com.example.hitos_proyecto.databinding.FragmentRegistroBinding
import com.example.hitos_proyecto.registro.data.remote.FirebaseRegistroRepository
import com.example.hitos_proyecto.registro.domain.RegistroUseCase
import com.example.hitos_proyecto.registro.domain.model.RegistroUsuario
import com.example.hitos_proyecto.registro.presentation.RegistroState
import com.example.hitos_proyecto.registro.presentation.RegistroViewModel
import com.example.hitos_proyecto.registro.presentation.RegistroViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_registro.*

class RegistroFragment : Fragment(R.layout.fragment_registro) {
    private lateinit var binding: FragmentRegistroBinding
    private lateinit var viewModel: RegistroViewModel
    private lateinit var viewModelFactory: RegistroViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        setupLiveData()
        setupBind(view)
        setupListeners()
    }

    private fun setupDependencies() {
        viewModelFactory = RegistroViewModelFactory(
            RegistroUseCase(
                FirebaseRegistroRepository(
                    FirebaseAuth.getInstance(),
                    FirebaseDatabase.getInstance()
                )
            )
        )

        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(RegistroViewModel::class.java)
    }

    private fun setupLiveData() {
        viewModel.getLiveData()
            .observe(viewLifecycleOwner,
                Observer { state -> state?.let { handleState(it) } }
            )
    }

    private fun handleState(state: RegistroState) {
        when (state) {
            is RegistroState.LoadingRegistroState -> showLoading()
            is RegistroState.ErrorRegistroState -> showError()
            is RegistroState.EmailAlreadyExist -> repeatedEmail()
            is RegistroState.SuccessRegistroState -> successRegister()
        }
    }

    private fun showLoading() {
        alert("Cargando...")
    }

    private fun showError() {
        alert("Error del servidor")
    }

    private fun repeatedEmail() {
        alert("El email ya esta siendo usado")
    }

    private fun successRegister() {
        alert("Registro exitoso")
    }

    private fun setupBind(view: View) {
        binding = FragmentRegistroBinding.bind(view)
    }

    private fun setupListeners() {
        binding.apply {
            btnRegistrar.setOnClickListener {
                if (validarValoresDelEditText()) {
                    viewModel.registrarUsuario(obtenerValoresDelEditText())
                }
            }

            btnVolver.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun validarValoresDelEditText(): Boolean {
        binding.apply {
            return et_confirmar_contrasena.isValidConfirmPassInput(
                "Las contraseñas deben coincidir",
                et_contrasena.text.toString()) ||
                    et_contrasena.isValidPassInput("Ingrese una contraseña valida") ||
                    et_email.isValidEmailInput("Ingrese un correo electrónico valido") ||
                    et_rut.isValidRutInput("Ingrese un RUN valido") ||
                    et_nombre.isValidNameInput("Ingrese un nombre valido")

        }
    }

    private fun obtenerValoresDelEditText(): RegistroUsuario {
        binding.apply {
            return RegistroUsuario(
                et_nombre.text.toString(),
                et_rut.text.toString(),
                et_email.text.toString(),
                et_contrasena.text.toString(),
                et_direccion.text.toString()
            )
        }
    }
}