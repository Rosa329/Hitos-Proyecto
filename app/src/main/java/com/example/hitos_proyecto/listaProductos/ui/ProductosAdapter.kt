package com.example.hitos_proyecto.listaProductos.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hitos_proyecto.databinding.ProductosviewBinding
import com.example.hitos_proyecto.listaProductos.domain.model.InfoProducto

class ProductosAdapter  (
    private val producto: List<InfoProducto>
) : RecyclerView.Adapter<ProductosViewHolder>() {

    private lateinit var binding: ProductosviewBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        binding = ProductosviewBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ProductosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        holder.bind(producto[position] )
    }

    override fun getItemCount(): Int {
        return producto.size
    }

}