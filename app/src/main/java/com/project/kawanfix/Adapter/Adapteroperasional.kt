package com.project.kawanfix.Adapter

import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.kawanfix.Detailaktivity
import com.project.kawanfix.R
import com.project.kawanfix.data_model
import org.w3c.dom.Text

class Adapteroperasional (private val array: List<data_model.Operasional>): RecyclerView.Adapter<Adapteroperasional.MyViewHolder>(){
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val hari :TextView = itemView.findViewById(R.id.hari)
        val jadwalbuka : TextView = itemView.findViewById(R.id.jadwalbuka)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.model_operaasional,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Adapteroperasional.MyViewHolder, position: Int) {
        val item =array[position]
        holder.hari.text = item.hari
        holder.jadwalbuka.text = item.jadwalbuka

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, Detailaktivity::class.java)
            intent.putExtra("detailproduk",array[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}