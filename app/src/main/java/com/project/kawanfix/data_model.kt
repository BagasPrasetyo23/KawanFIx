package com.project.kawanfix

import android.widget.TextView
import java.io.Serializable
import java.io.StringReader

data class data_model(
    var image: Int,
    var nama: String,
    var jarak: String,
    var imagewaktu:Int,
    var jadwal: String,
    var fasilitas:List<Fasilitas>,
    var operasional :List<Operasional>,
    var card :List<Card>,
    var imageslider :List<Imageslider>,
    var imagelokasi :Int,
    var deskripsi :String,
) : Serializable{
    data class Imageslider(
        val images :Int
    ):Serializable
    data class Card(
        val imagecard :Int,
        val textcard :String,
        val hargacard :String
    ):Serializable
    data class Fasilitas(
        val dot:Int,
        val ket :String
    ):Serializable
    data class Operasional(
        val hari :String,
        val jadwalbuka: String
    ):Serializable
}

