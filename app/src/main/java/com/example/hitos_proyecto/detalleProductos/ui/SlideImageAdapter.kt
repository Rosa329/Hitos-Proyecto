package com.example.hitos_proyecto.detalleProductos.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.hitos_proyecto.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SlideImageAdapter(
    private val context: Context,
    private var list: MutableList<SliderItem>
) : SliderViewAdapter<SliderAdapterVH>() {

    override fun getCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
        val inflate =
            LayoutInflater.from(parent?.context).inflate(R.layout.slider_imagenes_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {
        viewHolder?.bind(list[position])
    }

    fun renewItems(sliderItems: MutableList<SliderItem>) {
        this.list = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        this.list.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: SliderItem) {
        this.list.add(sliderItem)
        notifyDataSetChanged()
    }
}