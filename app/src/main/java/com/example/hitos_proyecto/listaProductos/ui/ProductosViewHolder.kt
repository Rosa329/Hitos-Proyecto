package com.example.hitos_proyecto.listaProductos.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.hitos_proyecto.databinding.ProductosviewBinding
import com.example.hitos_proyecto.listaProductos.domain.model.InfoProducto

class ProductosViewHolder (
    private val binding: ProductosviewBinding
): RecyclerView.ViewHolder(binding.root){

    fun bind(infoJuegos: InfoProducto){
        binding.apply {
            tvNombreProducto.text = infoJuegos.nombre


        }
    }
}