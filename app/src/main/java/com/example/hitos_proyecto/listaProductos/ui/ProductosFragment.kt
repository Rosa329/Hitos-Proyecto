package com.example.hitos_proyecto.listaProductos.ui

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import cl.talentodigital.consultavalores.util.extentions.alert
import com.example.hitos_proyecto.R
import com.example.hitos_proyecto.databinding.FragmentDetalleBinding
import com.example.hitos_proyecto.databinding.FragmentProductosBinding
import com.example.hitos_proyecto.listaProductos.data.remote.InfoProductoModel
import com.example.hitos_proyecto.listaProductos.data.remote.ProductosMapper
import com.example.hitos_proyecto.listaProductos.data.remote.RemoteProductosRepository
import com.example.hitos_proyecto.listaProductos.domain.ObtenerProductosUseCase
import com.example.hitos_proyecto.listaProductos.domain.model.Productos
import com.example.hitos_proyecto.listaProductos.presentation.*
import com.example.hitos_proyecto.network.api.RetrofitHandler
import com.example.hitos_proyecto.registro.presentation.RegistroViewModelFactory
import retrofit2.Retrofit


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
            rvProductos.layoutManager = LinearLayoutManager( requireContext())
            rvProductos.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun setupLiveData() {
      productosViewModel.getLiveData().observe(
          viewLifecycleOwner,
          {state -> productosHandlesState(state)}
      )
        productosViewModel.obtenerProductos() }

    private fun productosHandlesState(state: Any) {
        when (state) {
            is ProductosState.CargandoProductos -> mostrarCargando()
            is ProductosState.ObtenerTodosLosProductos -> state.resultProductos?.let { mostrarProductos(it) }
            is ProductosState.Error -> state.error?.let { mostrarErrorProductos(it) }
        }
    }
    private fun mostrarCargando(){
        alert("Cargando Productos")
    }

    private fun mostrarProductos(listaProductos: Productos){
        productosAdapter = ProductosAdapter(listaProductos.listadoDeProductos)
        binding.rvProductos.adapter = productosAdapter
    }

    private fun mostrarErrorProductos( error: Throwable){
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
    }

    private fun setupBind(view: View) {
        binding = FragmentProductosBinding.bind(view)
    }

    }





