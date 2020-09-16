package com.example.hitos_proyecto.detalleProductos.ui

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.hitos_proyecto.R
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso


class SliderAdapterVH(private val itemView: View) : SliderViewAdapter.ViewHolder(itemView){


    var imageViewBackground: ImageView = itemView.findViewById(R.id.iv_auto_image_slider)
    var imageGifContainer: ImageView =  itemView.findViewById(R.id.iv_gif_container)
    var textViewDescription: TextView = itemView.findViewById(R.id.tv_auto_image_slider)

    fun bind(item: SliderItem) {
        textViewDescription.text=item.description
        textViewDescription.setTextSize(16F)
        textViewDescription.setTextColor(Color.WHITE)
        Picasso.get().load(item.imageURL)
            .into(imageViewBackground)
    }
}