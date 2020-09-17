package com.example.hitos_proyecto.listaProductos.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.hitos_proyecto.databinding.ProductosviewBinding
import com.example.hitos_proyecto.listaProductos.domain.model.Producto
import com.squareup.picasso.Picasso

class ProductosViewHolder(
    private val binding: ProductosviewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(producto: Producto) {
        binding.apply {
            tvValor.text = producto.species
            tvNombreProducto.text = producto.name
            Picasso.get().load(producto.image).into(ivProducto)
        }
    }
}