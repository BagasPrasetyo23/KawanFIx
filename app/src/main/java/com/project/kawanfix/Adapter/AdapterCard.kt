package com.project.kawanfix.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.kawanfix.R
import com.project.kawanfix.data_model

class AdapterCard (private val Array:List<data_model.Card>):RecyclerView.Adapter<AdapterCard.MyViewHolder>() {
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val imagecard :ImageView = itemView.findViewById(R.id.imagecard)
        val textcard :TextView = itemView.findViewById(R.id.textcard)
        val hargacard :TextView = itemView.findViewById(R.id.hargacard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return AdapterCard.MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = Array[position]
        holder.imagecard.setImageResource(currentitem.imagecard)
        holder.textcard.text = currentitem.textcard
        holder.hargacard.text = currentitem.hargacard
    }

    override fun getItemCount(): Int {
        return Array.size
    }
}