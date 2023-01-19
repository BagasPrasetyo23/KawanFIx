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

class AdapterVertical (private val array: ArrayList<data_model>): RecyclerView.Adapter<AdapterVertical.MyViewHolder>() {

    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.image)
        val nama : TextView = itemView.findViewById(R.id.nama)
        val jarak : TextView = itemView.findViewById(R.id.jarak)
        val imagewaktu : ImageView = itemView.findViewById(R.id.imagewaktu)
        val jadwal : TextView = itemView.findViewById(R.id.jadwal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.model_vertical,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = array[position]
        holder.image.setImageResource(item.image)
        holder.nama.text = item.nama
        holder.jarak.text = item.jarak
        holder.imagewaktu.setImageResource(item.imagewaktu)
        holder.jadwal.text = item.jadwal

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,Detailaktivity::class.java)
            intent.putExtra("detailproduk",array[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }


}