package com.example.hitos_proyecto.listaProductos.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import cl.talentodigital.consultavalores.util.extentions.alert
import com.example.hitos_proyecto.R
import com.example.hitos_proyecto.databinding.FragmentProductosBinding
import com.example.hitos_proyecto.listaProductos.data.remote.ProductosMapper
import com.example.hitos_proyecto.listaProductos.data.remote.RemoteProductosRepository
import com.example.hitos_proyecto.listaProductos.domain.ObtenerProductosUseCase
import com.example.hitos_proyecto.listaProductos.domain.model.ListaProductos
import com.example.hitos_proyecto.listaProductos.presentation.*
import com.example.hitos_proyecto.network.api.RetrofitHandler


class ProductosFragment : Fragment(R.layout.fragment_productos) {

    private lateinit var binding: FragmentProductosBinding
    private lateinit var productosAdapter: ProductosAdapter
    private lateinit var productosViewModel: ProductosViewModel
    private lateinit var productosViewModelFactory: ProductosViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBind(view)
        setupDependencies()
        setupLiveData()
        setupRecyclerView()
        obtenerViewModel()
    }

    private fun obtenerViewModel() {
        productosViewModel.obtenerProductos()
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvProductos.setHasFixedSize(true)
            rvProductos.layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
    }

    private fun setupLiveData() {
        productosViewModel.getLiveData().observe(
            viewLifecycleOwner,
            { state -> productosHandleState(state) }
        )
        productosViewModel.obtenerProductos()
    }

    private fun productosHandleState(state: ProductosState) {
        when (state) {
            is ProductosState.CargandoProductos -> mostrarCargando()
            is ProductosState.ObtenerTodosLosProductos -> state.resultProductos?.let {
                mostrarProductos(
                    it
                )
            }
            is ProductosState.Error -> state.error?.let { mostrarErrorProductos(it) }
        }
    }

    private fun mostrarCargando() {
        alert("Cargando Productos")
    }

    private fun mostrarProductos(listaProductos: ListaProductos) {
        productosAdapter = ProductosAdapter(listaProductos.listaProductos)
        binding.rvProductos.adapter = productosAdapter
    }

    private fun mostrarErrorProductos(error: Throwable) {
        alert("Error :${error.message}")
    }

    private fun setupDependencies() {
        productosViewModelFactory = ProductosViewModelFactory(
            ObtenerProductosUseCase(
                RemoteProductosRepository(
                    RetrofitHandler.getApiProductos(),
                    ProductosMapper()
                )
            )
        )
        productosViewModel = ViewModelProvider(this, productosViewModelFactory)
            .get(ProductosViewModel::class.java)
    }

    private fun setupBind(view: View) {
        binding = FragmentProductosBinding.bind(view)
    }
}