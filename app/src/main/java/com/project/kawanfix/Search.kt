package com.project.kawanfix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.kawanfix.Adapter.AdapterSearch
import kotlinx.android.synthetic.main.activity_search.*
import java.util.*
import kotlin.collections.ArrayList

class Search : AppCompatActivity() {
    private lateinit var adapter: AdapterSearch
    private lateinit var recyclerView: RecyclerView
    private lateinit var data: ArrayList<data_model>

    lateinit var image: Array<Int>
    lateinit var nama: Array<String>
    lateinit var jarak: Array<String>
    lateinit var imagewaktu: Array<Int>
    lateinit var jadwal: Array<String>
    lateinit var deskripsi :Array<String>
    lateinit var imagelokasi:Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        setFullScreen(window)
        LightStatusBar(window)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val back: ImageButton = findViewById(R.id.back)
        back.setOnClickListener {
            finish()
        }

        dataInitialize()
        val layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recycler_view_seach)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterSearch(data)
        recyclerView.adapter = adapter

        val edt: EditText = findViewById(R.id.edt)

        edt.doOnTextChanged { text, _, _, _ ->
            val query = text.toString().lowercase(Locale.getDefault())
            filterWithQuery(query)
            toggleImageView(query)
        }
    }

    private fun attachAdapter(list: ArrayList<data_model>) {
        adapter = AdapterSearch(list)
        recyclerView.adapter = adapter
    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: ArrayList<data_model> = onFilterChanged(query)
            attachAdapter(filteredList)
            toggleImageView(query)
        } else if (query.isEmpty()) {
            attachAdapter(data as ArrayList<data_model>)
        }
    }

    private fun onFilterChanged(filterQuery: String): ArrayList<data_model> {
        val filteredList = ArrayList<data_model>()
        for (Menu in data) {
            if (Menu.nama.lowercase(Locale.getDefault()).contains(filterQuery)) {
                filteredList.add(Menu)
            }
        }
        return filteredList
    }


    private fun toggleImageView(query: String) {
        if (query.isNotEmpty()) {
            text2.visibility = View.VISIBLE
            hide.visibility = View.GONE
        } else if (query.isEmpty()) {
            text2.visibility = View.GONE
            hide.visibility = View.VISIBLE
        }
    }

    private fun dataInitialize() {
        data = arrayListOf<data_model>()

        image = arrayOf(
            R.drawable.masjidrayasumbar_xxxhdpi,
            R.drawable.pauhpiamanxxxhdpi,
            R.drawable.airterjunlubuakrantiang_xxxhdpi,
            R.drawable.pantaiairmanis_xxxhdpi,
            R.drawable.kulinerjembatansnb_xxxhdpi,
            R.drawable.airterjunlubuaktampuruang_xxxhdpi,
            R.drawable.pulausirandah_xxxhdpi,
            R.drawable.satedd_xxxhdpi,
            R.drawable.bendunganniagara_xxxhdpi,
            R.drawable.warungkopinanyo_xxxhdpi,
            R.drawable.katupekpitalahpurus3_xxxhdpi,
            R.drawable.pantaipadang_xxxhdpi,
            R.drawable.pulaupasumpahan_xxxhdpi,
            R.drawable.airterjunlubuakhitam_xxxhdpi,
            R.drawable.jamsit_xxxhdpi,
            R.drawable.lamunombakxxxhdpi,
            R.drawable.esdurianikogantinyo_xxxhdpi,
            R.drawable.esduriangantinanlamo_xxxhdpi
        )

        nama = arrayOf(
            "Masjid raya sumatra barat",
            "Rumah makan pauh piaman",
            "Air terjun lubuak rantiang",
            "Pantai air manis",
            "Kuliner jembatan siti nurbaya",
            "Air terjun lubuak tampuruang",
            "Pulau sirandah",
            "Sate daguang-danguang",
            "Bendungan Niagara",
            "Warung kopi nan yo",
            "Katupek pitalah purus 3",
            "Pantai padang",
            "Pulau pasumpahan",
            "Air terjun lubuak hitam",
            "Jembatan siti nurbaya",
            "Rumah makan lamun ombak",
            "Es durian iko gantinyo",
            "Es durian ganti nan lamo"
        )

        jarak = arrayOf(
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km"
        )

        imagewaktu = arrayOf(
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock
        )

        jadwal = arrayOf(
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka"
        )

        val fasilitas = listOf<List<data_model.Fasilitas>>(
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir Motor dan Mobil"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet umum"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Spot foto"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir Mobil dan Motor"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Penginapan"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Transportasi menyebrang"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet Umum"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir Motor dan Mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir Motor dan Mobil"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir Motor dan Mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet umum"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Masjid dan mushola"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Joging track"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet umum"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Penginapan"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Mushola"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Area berkemah"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Spot foto"
                ),
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir Motor dan Mobil"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir motor dan mobil"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet"
                )
            ),
            listOf<data_model.Fasilitas>(
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Parkir Motor dan Mobil"
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet"
                )
            )
        )

        val operasionals = listOf<List<data_model.Operasional>>(
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "04.00 - 00.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "08.00 - 21.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "12.00 - 24.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "08.00 - 18.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "17.00 - 22.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin",
                    jadwalbuka = "Tutup"
                ),
                data_model.Operasional(
                    hari = "Selasa-Minggu",
                    jadwalbuka = "09:00 - 17.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "08.00 - 18.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "16.30 - 23.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "08.00 - 18.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "06.00 - 17.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "06.00 - 11.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "00.00 - 00.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "00.00 - 00.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Kamis",
                    jadwalbuka = "14:00 - 18.00"
                ),
                data_model.Operasional(
                    hari = "Sabtu-Minggu",
                    jadwalbuka = "09:00 - 18.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "17.00 - 00.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "10.00 - 21.000"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Jumat",
                    jadwalbuka = "09.00 - 22.00"
                ),
                data_model.Operasional(
                    hari = "Sabtu - Minggu",
                    jadwalbuka = "09.00 - 22.30"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "06.00 - 17.00"
                )
            )
        )

        val cards = listOf<List<data_model.Card>>(
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Free"
                ),
                data_model.Card(
                    imagecard = R.drawable.ic_parking,
                    textcard = "Parkir",
                    hargacard = "Rp 2.000 - Rp 5.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_food,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 19.500"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Rp 5.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket maasuk",
                    hargacard = "Rp 5.000 - Rp 10.000"
                ),
                data_model.Card(
                    imagecard = R.drawable.ic_parking,
                    textcard = "Parkir",
                    hargacard = "Rp 2.000 - Rp 5.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_food,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 8.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Rp 5.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Paket Wisata",
                    hargacard = "Rp 500.000 - Rp 2.000.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_sate,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 17.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Free"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_coffee_cup,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 23.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_food,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 10.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Free"
                ),
                data_model.Card(
                    imagecard = R.drawable.ic_parking,
                    textcard = "Parkir",
                    hargacard = "Rp 2.000 - Rp 5.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket maasuk",
                    hargacard = "Rp 15.000"
                ),
                data_model.Card(
                    imagecard = R.drawable.ic_boat,
                    textcard = "Transportasi menyebrang",
                    hargacard = "Rp 50.000 - Rp 75.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Rp 5.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Free"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_food,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 30.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ice_cream,
                    textcard = "Harga mulai dari",
                    hargacard = "Rp 10.000"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ice_cream,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 10.000"
                )
            ),
        )
        val imagesliders = listOf<List<data_model.Imageslider>>(
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.masjidrayasumbar_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.masjidraya2
                ),
                data_model.Imageslider(
                    images = R.drawable.masjidraya3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.pauhpiamanxxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.rumahmakanpauh2
                ),
                data_model.Imageslider(
                    images = R.drawable.rumahmakanpauh3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.airterjunlubuakrantiang_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.rantiang2
                ),
                data_model.Imageslider(
                    images = R.drawable.rantiang3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.pantaiairmanis_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.airmanis2
                ),
                data_model.Imageslider(
                    images = R.drawable.airmanis3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.kulinerjembatansnb_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.jamsit2
                ),
                data_model.Imageslider(
                    images = R.drawable.jamsit3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.airterjunlubuaktampuruang_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.tampuruang2
                ),
                data_model.Imageslider(
                    images = R.drawable.tampuruang3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.pulausirandah_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.sirandah2
                ),
                data_model.Imageslider(
                    images = R.drawable.sirandah3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.satedd_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.satedd2
                ),
                data_model.Imageslider(
                    images = R.drawable.satedd3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.bendunganniagara_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.bendungan2
                ),
                data_model.Imageslider(
                    images = R.drawable.bendungan3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.warungkopinanyo_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.kopinanyo2
                ),
                data_model.Imageslider(
                    images = R.drawable.kopinanyo3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.katupekpitalahpurus3_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.katupek2
                ),
                data_model.Imageslider(
                    images = R.drawable.katupek3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.pantaipadang_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.pantaipadang2
                ),
                data_model.Imageslider(
                    images = R.drawable.pantaipadang3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.pulaupasumpahan_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.pasumpahan2
                ),
                data_model.Imageslider(
                    images = R.drawable.pasumpahan3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.airterjunlubuakhitam_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.lubuakhitam2
                ),
                data_model.Imageslider(
                    images = R.drawable.lubuakhitam3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.jamsit_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.jamsit2
                ),
                data_model.Imageslider(
                    images = R.drawable.jamsit3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.lamunombakxxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.lamunombak2
                ),
                data_model.Imageslider(
                    images = R.drawable.lamunombak3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.esdurianikogantinyo_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.ikogantinyo2
                ),
                data_model.Imageslider(
                    images = R.drawable.ikogantinyo3
                ),
            ),
            listOf<data_model.Imageslider>(
                data_model.Imageslider(
                    images = R.drawable.esduriangantinanlamo_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.gantinanlamo2
                ),
                data_model.Imageslider(
                    images = R.drawable.gantinanlamo3
                ),
            ),
        )

        deskripsi = arrayOf(
            "Masjid Raya Sumatera Barat dikenal dengan arsitekturnya yang unik. Masjid ini tidak memiliki kubah, melainkan menggunakan arsitektur Rumah Gadang dengan empat sudut lancip khas budaya Minangkabau. Bangunan dari Masjid Raya Sumatera Barat ini berbentuk lonjong dengan luas mencapai 18.000 m2.",
            "Rumah makan Pauh Piaman adalah rumah makan Padang yang pas untuk merasakan bagaimana rasanya menikmati nasi Padang di Kota Padang. Hidangan favorit dari tempat ini adalah gulai kepala ikan yang diolah dengan rempah-rempah khas masakan Padang.",
            "Lubuak Rantiang merupakan tempat wisata di Padang berupa air terjun yang memiliki kolam di aliran sungainya. Lokasinya berada di daerah Sungai Bangek. Meskipun hanya setinggi 6 meter, namun air terjun yang dikenal dengan Lubuak Ngalauan, atau Sarasah Lubuak Rantiang ini menyuguhkan panorama indah. Belum lagi dilengkapi dengan air berwarna kehijauan bening yang sangat menyegarkan untuk berenang.",
            "Pantai Air Manis merupakan tempat wisata di Padang yang ikonik. Di pantai ini terdapat sebuah batu yang menyerupai bentuk manusia tengah bersujud. Batu ini diyakini sebagai bentuk Malin Kundang yang dikutuk sang ibu. Salah satu hal yang tak kalah menarik, karena ada juga bebatuan yang berbentuk tali tambang kapal serta kayu yang menyerupai bentuk pecahan badan kapal. Penduduk setempat juga percaya bahwa batu-batuan tersebut tidak hanya sebatas kebetulan, melainkan menjadi bukti jika legenda dari Malin Kundang memang sungguh terjadi.",
            "Jembatan Siti Nurbaya memang terkenal sebagai tujuan wisata, namun pada malam hari, tempat ini berubah menjadi tujuan wisata kuliner Padang kaki lima yang terkenal akan sajian jagung bakar dan juga pisang kapiak. Suasana malam jembatan ditemani temaram lampu jalanan tentu akan membuat hidangan menjadi semakin lezat.",
            "Air Terjun Lubuak Tampuruang berada di Gunung Sarik, Kuranji, Padang. Lubuak Tampuruang terdiri dari air terjun kecil dari sungai yang mengalir tidak terlalu deras. Lubuak Tampuruang berasal dari kata Lubuak yang berarti kolam alami dan Tampuruang yang berarti batok kelapa. Nama ini diambil karena bentuk air terjun yang kecil dan sungainya hampir membentuk setengah lingkaran seperti batok kelapa.",
            "Pulau Sirandah adalah sebuah pulau yang termasuk dalam wilayah administrasi Kecamatan Bungus Teluk Kabung, Kota Padang. Sirandah berasal dari bahasa Minang yang berarti rendah. Pulau Sirandah merupakan pulau berbukit dengan pantai berpasir putih yang ditumbuhi beberapa jenis pohon tingkat tinggi seperti kelapa, semak dan bakau.",
            "Ke Padang tanpa mencoba wisata kuliner sate padang tentu tidakak akan afdol. Salah satu tempat berburu sate padang paling terkenal di Padang adalah Sate Danguang-Danguang. Dengan kuah saus sate padang yang khas dan daging sapi yang gurih, sate padang daguang-daguang menjadi spot wisata kuliner favorit di Padang.",
            "Tempat wisata di Padang berikutnya adalah Bendungan Niagara Koto Pulai. Sesuai namanya, bendungan ini memiliki bentuk layaknya air terjun niagara. Lokasinya berada di Koto Pulai, Kecamatan Koto Tangah, Kota Padang. Awalnya, Bendungan Koto Pulai ini bukanlah tempat wisata, namun karena keindahan pemandangan dan bentuknya yang menyerupai Niagara, lokasi ini mulai sering didatangi pengunjung untuk berwisata.",
            "Kota Padang memiliki warung kopi legendaris dengan nuansa pecinan tempo dulu. Tujuan wisata kuliner ini paling sering dikunjungi pada saat pagi hari untuk sarapan. Menu andalan dari kedai kopi ini adalah Kopi Es dan juga mie goreng.",
            "Katupek pitalah merupakan makanan khas daerah Pitalah yang ada di Padang. Restoran yang paling terkenal dengan menu ini adalah restoran Katupek Pitalah Purus 3. Makanan ini berisi potongan ketupat dengan siraman kuah kuning yang berisi nangka dan rebung. Beroperasi mulai pagi hari, makanan ini cocok sebagai menu sarapanmu. Selain katupek pitalah, restoran ini juga menyediakan pical, bubur hitam, dan juga nasi goreng.",
            "Pantai Padang merupakan salah satu tempat wisata di Padang terfavorit. Terlebih setelah Pemerintah Kota Padang memoles destinasi ini dengan berbagai fasilitas. Ketika cuaca cerah, Pantai Padang termasuk tempat yang ideal untuk menyaksikan matahari terbenam di ufuk barat dengan bias merahnya yang mengagumkan.",
            "Pulau Pasumpahan berada di sisi barat Pantai Padang dengan luas sekitar 5 hektar. Pasir di Pantai Pulau Pasumpahan berwarna putih, berpadu dengan jernihnya air laut yang berwarna biru sejauh mata memandang. Daya tarik lain yang dimiliki tempat wisata di Padang ini adalah permukaan laut yang seolah terbagi menjadi tiga warna dengan gradasi warna bening, hijau, dan biru jika dilihat dari bibir pantai.",
            "Air Terjun Lubuk Hitam secara administratif berada di Kelurahan Teluk Kabung Utara, Kecamatan Bungus Teluk Kabung. Air terjun ini memiliki tiga tingkatan yang indah. Ketinggian masing-masing air terjun dimulai sekitar 2 meter, 10 meter, dan 20 meter.",
            "Jembatan Siti Nurbaya merupakan tempat wisata di Padang yang sangat ikonik. Jembatan ini membentang sepanjang 156 meter di atas Sungai Batang Aru. Pemberian nama Siti Nurbaya sendiri tidak lain karena karena fungsinya sebagai akses penghubung menuju Gunung Padang yang menjadi latar tempat novel klasik Siti Nurbaya. Selain sebagai jalur akses penghubung, jembatan ini biasanya juga dijadikan tempat untuk menikmati panorama matahari terbenam dengan pemandangan Kota Tua Padang.",
            "Pilihan tempat merasakan lezatnya nasi Padang adalah Restoran Lamun Ombak. Disini Kamu bisa menemukan menu lengkap mulai dari rendang, asam padeh, gulai otak, dendeng balado, hingga ayam pop. Dengan citarasa yang lezat, tujuan wisata kuliner Padang satu ini tak pernah sepi pengunjung.",
            "Pilihan kuliner Es Durian lainnya yang bisa Toppers coba saat berkunjung ke Padang adalah Es Durian Iko Gantinyo. Tempat ini juga populer sebagai tempat nongkrong para pecinta kuliner durian di Padang. Selain Es Durian, tersedia juga menu sate padang dan juga pempek sebagai pendamping Es Durian yang kamu pesan.",
            "Sehabis menikmati santap kuliner Padang, saatnya menikmati hidangan pencuci mulut. Es Durian Ganti Nan Lamo adalah tujuan wisata kuliner Padang yang tepat untuk kamu penggemar buah durian. Berdiri sejak 1960, cita rasa dari es durian di tempat ini masih terjaga dan tetap digemari.",
        )

        imagelokasi = arrayOf(
            R.drawable.masjidraya,
            R.drawable.rumah_makanpiaman,
            R.drawable.airterjunlubuakrantiang,
            R.drawable.pantaiairmanis,
            R.drawable.kuliner_jembatansitinurbaya,
            R.drawable.airterjunlubuaktampuruang,
            R.drawable.pulausirandah,
            R.drawable.satedd,
            R.drawable.bendunganniagara,
            R.drawable.warungkopinanyo,
            R.drawable.katupek_pitalah,
            R.drawable.pantaipadang,
            R.drawable.pulaupasumpahan,
            R.drawable.airtejublubuakhitam,
            R.drawable.jamsit,
            R.drawable.rumah_makan_lamunombak,
            R.drawable.esdurianikogantinyo,
            R.drawable.esduriangantinanlamo
        )

        for (i in image.indices) {
            val wisata = data_model(
                image[i],
                nama[i],
                jarak[i],
                imagewaktu[i],
                jadwal[i],
                fasilitas[i],
                operasionals[i],
                cards[i],
                imagesliders[i],
                imagelokasi[i],
                deskripsi[i]
            )
            data.add(wisata)
        }
    }
}