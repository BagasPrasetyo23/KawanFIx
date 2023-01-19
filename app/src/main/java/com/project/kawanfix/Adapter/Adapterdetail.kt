package com.project.kawanfix.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.kawanfix.Detailaktivity
import com.project.kawanfix.R
import com.project.kawanfix.data_model

class Adapterdetail(private val array: List<data_model.Fasilitas>)
    : RecyclerView.Adapter<Adapterdetail.MyViewHolder>() {
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val image : ImageView =itemView.findViewById(R.id.dot)
        val text : TextView = itemView.findViewById(R.id.ket)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.model_text,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item =array[position]
        holder.image.setImageResource(item.dot)
        holder.text.text=item.ket
    }

    override fun getItemCount(): Int {
        return array.size
    }
}