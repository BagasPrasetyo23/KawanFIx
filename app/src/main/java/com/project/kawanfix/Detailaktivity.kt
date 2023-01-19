package com.project.kawanfix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.project.kawanfix.Adapter.AdapterCard
import com.project.kawanfix.Adapter.Adapter_image
import com.project.kawanfix.Adapter.Adapterdetail
import com.project.kawanfix.Adapter.Adapteroperasional
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.activity_detailaktivity.*
import kr.co.prnd.readmore.ReadMoreTextView

class Detailaktivity : AppCompatActivity() {
    private lateinit var adapter : Adapterdetail
    private lateinit var recyclerView: RecyclerView
//    private lateinit var array:ArrayList<data_model>

    private lateinit var adapteroperasional :Adapteroperasional
    private lateinit var recyclerViewoperasional: RecyclerView

    private lateinit var adaptercard :AdapterCard
    private lateinit var recyclerViewcard: RecyclerView
//    private lateinit var arrayoperasional :ArrayList<data_model>

    private lateinit var adapterimage :Adapter_image
    private lateinit var ViewPager2 : ViewPager2

    private lateinit var iv1 :ImageView
    private lateinit var iv2 :ImageView
    private lateinit var iv3 :ImageView


    lateinit var image:Array<Int>
    lateinit var nama:Array<String>
    lateinit var jarak:Array<String>
    lateinit var imagewaktu:Array<Int>
    lateinit var jadwal:Array<String>
    lateinit var deskripsi :Array<String>
//    lateinit var dot : Array<Int>
//    lateinit var ket : Array<String>
//    lateinit var hari :Array<String>
//    lateinit var jadwalbuka:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailaktivity)
        val back: ImageButton = findViewById(R.id.back)

        back.setOnClickListener {
            finish()
        }

        val detailProduk: data_model = intent.getSerializableExtra("detailproduk") as data_model
        val title: TextView = findViewById(R.id.title)
        val deskripsi: ReadMoreTextView = findViewById(R.id.deskripsi)
        val imagelokasi: ImageView = findViewById(R.id.imagelokasi)

        title.text = detailProduk.nama
        deskripsi.text = detailProduk.deskripsi
        imagelokasi.setImageResource(detailProduk.imagelokasi)


//        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Adapterdetail(detailProduk.fasilitas)
        recyclerView.adapter = adapter

//        dataIntializeoperasional()
        recyclerViewoperasional = findViewById(R.id.recycler_view_fasilitas)
        recyclerViewoperasional.setHasFixedSize(true)
        adapteroperasional = Adapteroperasional(detailProduk.operasional)
        recyclerViewoperasional.adapter = adapteroperasional

        recyclerViewcard = findViewById(R.id.recycler_view_card)
        recyclerViewcard.setHasFixedSize(true)
        adaptercard = AdapterCard(detailProduk.card)
        recyclerViewcard.adapter = adaptercard

        ViewPager2 = findViewById(R.id.view_pager2)
        adapterimage = Adapter_image(detailProduk.imageslider)
        ViewPager2.adapter = adapterimage

        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)

        ViewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changedrawable()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changedrawable()
            }
        })
    }
    fun changedrawable(){
        when(ViewPager2.currentItem){
            0->{
                iv1.setImageResource(R.drawable.shape_dot_selected)
                iv2.setImageResource(R.drawable.shpae_dot_unselected)
                iv3.setImageResource(R.drawable.shpae_dot_unselected)
            }
            1->{
                iv1.setImageResource(R.drawable.shpae_dot_unselected)
                iv2.setImageResource(R.drawable.shape_dot_selected)
                iv3.setImageResource(R.drawable.shpae_dot_unselected)
            }
            2->{
                iv1.setImageResource(R.drawable.shpae_dot_unselected)
                iv2.setImageResource(R.drawable.shpae_dot_unselected)
                iv3.setImageResource(R.drawable.shape_dot_selected)
            }
        }
    }

}