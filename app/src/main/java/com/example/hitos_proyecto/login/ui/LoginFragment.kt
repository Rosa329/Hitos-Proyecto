package com.example.hitos_proyecto.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import cl.talentodigital.consultavalores.util.extentions.alert
import cl.talentodigital.consultavalores.util.validator.EmailValidator
import cl.talentodigital.consultavalores.util.validator.PassValidator
import com.example.hitos_proyecto.R
import com.example.hitos_proyecto.databinding.FragmentLoginBinding
import com.example.hitos_proyecto.login.data.remote.FirebaseLoginRepository
import com.example.hitos_proyecto.login.domain.LoginUseCase
import com.example.hitos_proyecto.login.presentation.LoginState
import com.example.hitos_proyecto.login.presentation.LoginViewModel
import com.example.hitos_proyecto.login.presentation.LoginViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDependencies()
        setupBinding(view)
        setupLiveData()
        setupListeners()
    }

    private fun setupDependencies() {
        viewModelFactory = LoginViewModelFactory(
            LoginUseCase(
                FirebaseLoginRepository(
                    FirebaseAuth.getInstance()
                )
            )
        )

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(LoginViewModel::class.java)
    }

    private fun setupBinding(view: View) {
        binding = FragmentLoginBinding.bind(view)
    }

    private fun setupLiveData() {
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            { state -> state?.let { handleState(it) } }
        )
    }

    private fun handleState(state: LoginState) {
        when (state) {
            is LoginState.LoadingLogin -> showLoading()
            is LoginState.SuccessLogin -> showSuccessLogin()
            is LoginState.InvalidUser -> showInvlaidUser()
            is LoginState.Error -> showError()
        }
    }

    private fun showLoading() {
        alert("Cargando")
    }

    private fun showSuccessLogin() {
        alert("Login exitoso") //Cambio a siguiente fragment por navigation
    }

    private fun showInvlaidUser() {
        alert("Usuario invalido")
    }

    private fun showError() {
        alert("Error")
    }

    private fun setupListeners() {
        binding.apply {
            btnIngresar.setOnClickListener {
                if (validarValoresDelEditText()) {
                    viewModel.ingresarUsuario(etEmail.text.toString(), etContrasena.text.toString())
                Navigation.findNavController(it)
                    .navigate(R.id.action_loginFragment_to_productosFragment)
                }
            }

            btnRegistrar.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_loginFragment_to_registroFragment)

            }
        }
    }

    private fun validarValoresDelEditText(): Boolean {
        var retorno = true
        binding.apply {
            if (!PassValidator.validate(etContrasena.text.toString())) {
                etContrasena.error = "Contraseña invalida"
                retorno = false
            }

            if (!EmailValidator.validate(etEmail.text.toString())) {
                etContrasena.error = "Email invalido"
                retorno = false
            }
        }
        return retorno
    }
}