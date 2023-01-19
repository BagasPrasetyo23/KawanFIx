package com.project.kawanfix.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.project.kawanfix.R
import com.project.kawanfix.data_model

class Adapter_image (private val images :List<data_model.Imageslider>): RecyclerView.Adapter<Adapter_image.ViewPagerViewHolder>() {

    class ViewPagerViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentitem = images[position]
        holder.imageView.setImageResource(currentitem.images)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}