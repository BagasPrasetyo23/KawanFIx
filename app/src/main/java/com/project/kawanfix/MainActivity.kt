package com.project.kawanfix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.kawanfix.Adapter.AdapterHorizontalScroll

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var adapter : AdapterHorizontalScroll
    private lateinit var recyclerView: RecyclerView
//   private lateinit var arrayList: ArrayList<data_model>

    private lateinit var adapter_kuliner : AdapterHorizontalScroll
    private lateinit var recyclerView_kuliner: RecyclerView
//    private lateinit var arrayList_kuliner: ArrayList<data_model>
//
//    lateinit var image:Array<Int>
//    lateinit var nama:Array<String>
//    lateinit var jarak:Array<String>
//    lateinit var imagewaktu:Array<Int>
//    lateinit var jadwal:Array<String>
override fun onCreate(savedInstanceState: Bundle?) {
    setFullScreen(window)
    LightStatusBar(window, false)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

//        dataInitialize()
//        dataInitialize_kuliner()
    val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    recyclerView = findViewById(R.id.recycler_view)
    recyclerView.layoutManager = layoutManager
    recyclerView.setHasFixedSize(true)
    adapter = AdapterHorizontalScroll(datamenu().dataInitialize())
    recyclerView.adapter = adapter

    recyclerView_kuliner = findViewById(R.id.recycler_view_kuliner)
    recyclerView_kuliner.setHasFixedSize(true)
    adapter_kuliner = AdapterHorizontalScroll(datamenu().dataInitialize_kuliner())
    recyclerView_kuliner.adapter = adapter_kuliner

    val card :CardView = findViewById(R.id.card)
    card.setOnClickListener(this)

    val card_profile :CardView = findViewById(R.id.card_profile)
    card_profile.setOnClickListener(this)

    val wisata = findViewById<ImageView>(R.id.wisata)
    wisata.setOnClickListener{
        val intent = Intent(this, Search_Wisata::class.java)
        startActivity(intent)
    }

    val kuliner = findViewById<ImageView>(R.id.kuliner)
    kuliner.setOnClickListener{
        val intent = Intent(this, Search_kuliner::class.java)
        startActivity(intent)
    }

    val semuawisata = findViewById<TextView>(R.id.semuawisata)
    semuawisata.setOnClickListener{
        val intent = Intent(this, MoreHighlighWisata::class.java)
        startActivity(intent)
    }

    val semuakuliner = findViewById<TextView>(R.id.semuakuliner)
    semuakuliner.setOnClickListener{
        val intent = Intent(this, MoreHighlightKuliner::class.java)
        startActivity(intent)
    }
}

    override fun onClick(v: View?) {
        if (v !=null){
            when(v.id){
                R.id.card->{
                    val intent = Intent(this,Search::class.java)
                    startActivity(intent)
                }
                R.id.card_profile->{
                    val intent = Intent(this,profil::class.java)
                    startActivity(intent)
                }
            }
        }
    }

//    private fun dataInitialize(){
//        arrayList = arrayListOf<data_model>()
//        image = arrayOf(
//            R.drawable.airterjunlubuaktampuruang_xxxhdpi,
//            R.drawable.airterjunlubuakrantiang_xxxhdpi,
//            R.drawable.airterjunlubuakhitam_xxxhdpi,
//            R.drawable.pulausirandah_xxxhdpi,
//            R.drawable.bendunganniagara_xxxhdpi
//        )
//        nama = arrayOf(
//            "Air Terjun Lubuak Tampuruang",
//            "Air Terjun Lubuak Rantiang",
//            "Air Terjun Lubuak Hitam",
//            "Pulau Sirandah",
//            "Bendungan Niagara",
//        )
//        jarak = arrayOf(
//            "5.0 Km",
//            "5.0 Km",
//            "5.0 Km",
//            "5.0 Km",
//            "5.0 Km"
//        )
//        imagewaktu = arrayOf(
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock
//        )
//        jadwal = arrayOf(
//            "Buka",
//            "Buka",
//            "Buka",
//            "Buka",
//            "Buka"
//        )
//
//        for (i in image.indices){
//            val wisata = data_model(image[i],nama[i],jarak[i],imagewaktu[i],jadwal[i])
//            arrayList.add(wisata)
//        }
//    }
//    private fun dataInitialize_kuliner(){
//        arrayList_kuliner = arrayListOf<data_model>()
//        image = arrayOf(
//            R.drawable.esdurianikogantinyo_xxxhdpi,
//            R.drawable.katupekpitalahpurus3_xxxhdpi,
//            R.drawable.satedd_xxxhdpi,
//            R.drawable.rumahmakanpauhpiaman_xxxhdpi,
//            R.drawable.warungkopinanyo_xxxhdpi
//        )
//        nama = arrayOf(
//            "Es durian iko gantinyo",
//            "Katupek pitalah purus 3",
//            "Sate danguang-daguang",
//            "Rumah Makan pauh piaman",
//            "Warung kopi nan yo",
//        )
//        jarak = arrayOf(
//            "5.0 Km",
//            "5.0 Km",
//            "5.0 Km",
//            "5.0 Km",
//            "5.0 Km"
//        )
//        imagewaktu = arrayOf(
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock,
//            R.drawable.ic_ic_clock
//        )
//        jadwal = arrayOf(
//            "Buka",
//            "Buka",
//            "Buka",
//            "Buka",
//            "Buka"
//        )
//
//        for (i in image.indices){
//            val Kuliner = data_model(image[i],nama[i],jarak[i],imagewaktu[i],jadwal[i])
//            arrayList_kuliner.add(Kuliner)
//        }
//    }
}