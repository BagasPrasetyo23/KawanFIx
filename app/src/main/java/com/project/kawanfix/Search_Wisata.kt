package com.project.kawanfix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.kawanfix.Adapter.AdapterVertical
import java.util.*
import kotlin.collections.ArrayList

class Search_Wisata : AppCompatActivity() {

    private lateinit var adapter: AdapterVertical
    private lateinit var recyclerView: RecyclerView
    private lateinit var data: ArrayList<data_model>

//    lateinit var hari : Array<String>
//    lateinit var jadwalbuka : Array<String>
    lateinit var image:Array<Int>
    lateinit var nama:Array<String>
    lateinit var jarak:Array<String>
    lateinit var imagewaktu:Array<Int>
    lateinit var jadwal:Array<String>
//    lateinit var imagebanner : Array<Int>
//    lateinit var textbanner :Array<String>
//    lateinit var hargabanner:Array<String>
    lateinit var deskripsi :Array<String>
    lateinit var imagelokasi:Array<Int>
//    lateinit var dot:Array<Int>
//    lateinit var ket:Array<String>
//    lateinit var hari :Array<String>
//    lateinit var jadwalbuka:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen(window)
        LightStatusBar(window)
        setContentView(R.layout.activity_search_wisata)

        val back : ImageButton = findViewById(R.id.back)
        back.setOnClickListener{
            finish()
        }

        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.recyclerviewWisata)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterVertical(data)
        recyclerView.adapter = adapter

        val editText : EditText = findViewById(R.id.et_wisata)

        editText.doOnTextChanged { text, _, _, _ ->
            val query = text.toString().lowercase(Locale.getDefault())
            filterWithQuery(query)
        }
    }

    private fun attachAdapter(list: ArrayList<data_model>) {
        adapter = AdapterVertical(list)
        recyclerView.adapter = adapter
    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: ArrayList<data_model> = onFilterChanged(query)
            attachAdapter(filteredList)
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

    private fun dataInitialize(){
        data = arrayListOf<data_model>()
        image = arrayOf(
            R.drawable.airterjunlubuakrantiang_xxxhdpi,
            R.drawable.airterjunlubuaktampuruang_xxxhdpi,
            R.drawable.airterjunlubuakhitam_xxxhdpi,
            R.drawable.bendunganniagara_xxxhdpi,
            R.drawable.jamsit_xxxhdpi,
            R.drawable.masjidrayasumbar_xxxhdpi,
            R.drawable.pantaipadang_xxxhdpi,
            R.drawable.pantaiairmanis_xxxhdpi,
            R.drawable.pulausirandah_xxxhdpi,
            R.drawable.pulaupasumpahan_xxxhdpi,
        )
        nama = arrayOf(
            "Air terjun lubuak rantiang",
            "Air terjun lubuak tampuruang",
            "Air terjun lubuak hitam",
            "Bendungan Niagara",
            "Jembatan siti nurbaya",
            "Masjid raya sumatra barat",
            "Pantai padang",
            "Pantai air manis",
            "Pulau sirandah",
            "Pulau pasumpahan",
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
        )
//        dot = arrayOf(
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//            R.drawable.ic_dot,
//        )
//
//        ket = arrayOf(
//            "bagus",
//            "bagus",
//            "bagus",
//            "bagus",
//            "bagus",
//            "bagus",
//            "bagus",
//            "bagus",
//            "bagus",
//            "bagus",
//        )
//        hari = arrayOf(
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//            "senin-jumat",
//        )
//        jadwalbuka = arrayOf(
//            "00:22",
//            "00:22",
//            "00:22",
//            "00:22",
//            "00:22",
//            "00:22",
//            "00:22",
//            "00:22",
//            "00:22",
//            "00:22",
//        )

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
            )
        )

        val operasionals = listOf<List<data_model.Operasional>>(
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin-Minggu",
                    jadwalbuka = "12.00 - 24.00"
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
                    jadwalbuka = "08.00 - 18.00"
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
                    hari = "Senin-Minggu",
                    jadwalbuka = "04.00 - 00.00"
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
                    jadwalbuka = "08.00 - 18.00"
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
                    hari = "Senin-Minggu",
                    jadwalbuka = "00.00 - 00.00"
                )
            )
        )

        val cards = listOf<List<data_model.Card>>(
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
                    hargacard = "Rp 5.000"
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
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Tiket masuk",
                    hargacard = "Free"
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
                    imagecard = R.drawable.ic_ticket,
                    textcard = "Paket Wisata",
                    hargacard = "Rp 500.000 - Rp 2.000.000"
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
        )

//
//        imagebanner = arrayOf(
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people,
//            R.drawable.ic_people
//        )
//
//        textbanner = arrayOf(
//            "Dewasa",
//            "Dewasa",
//            "Dewasa",
//            "Dewasa",
//            "Dewasa",
//            "Dewasa",
//            "Dewasa",
//            "Dewasa",
//            "Dewasa",
//            "Dewasa"
//        )
//
//        hargabanner = arrayOf(
//            "Rp 10.000",
//            "Rp 20.000",
//            "Rp 30.000",
//            "Rp 40.000",
//            "Rp 50.000",
//            "Rp 60.000",
//            "Rp 70.000",
//            "Rp 80.000",
//            "Rp 90.000",
//            "Rp 100.000"
//        )
        val imagesliders = listOf<List<data_model.Imageslider>>(
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
                    images = R.drawable.pulaupasumpahan_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.pasumpahan2
                ),
                data_model.Imageslider(
                    images = R.drawable.pasumpahan3
                ),
            ),
        )

        deskripsi = arrayOf(
            "Lubuak Rantiang merupakan tempat wisata di Padang berupa air terjun yang memiliki kolam di aliran sungainya. Lokasinya berada di daerah Sungai Bangek. Meskipun hanya setinggi 6 meter, namun air terjun yang dikenal dengan Lubuak Ngalauan, atau Sarasah Lubuak Rantiang ini menyuguhkan panorama indah. Belum lagi dilengkapi dengan air berwarna kehijauan bening yang sangat menyegarkan untuk berenang.",
            "Air Terjun Lubuak Tampuruang berada di Gunung Sarik, Kuranji, Padang. Lubuak Tampuruang terdiri dari air terjun kecil dari sungai yang mengalir tidak terlalu deras. Lubuak Tampuruang berasal dari kata Lubuak yang berarti kolam alami dan Tampuruang yang berarti batok kelapa. Nama ini diambil karena bentuk air terjun yang kecil dan sungainya hampir membentuk setengah lingkaran seperti batok kelapa.",
            "Air Terjun Lubuk Hitam secara administratif berada di Kelurahan Teluk Kabung Utara, Kecamatan Bungus Teluk Kabung. Air terjun ini memiliki tiga tingkatan yang indah. Ketinggian masing-masing air terjun dimulai sekitar 2 meter, 10 meter, dan 20 meter.",
            "Tempat wisata di Padang berikutnya adalah Bendungan Niagara Koto Pulai. Sesuai namanya, bendungan ini memiliki bentuk layaknya air terjun niagara. Lokasinya berada di Koto Pulai, Kecamatan Koto Tangah, Kota Padang. Awalnya, Bendungan Koto Pulai ini bukanlah tempat wisata, namun karena keindahan pemandangan dan bentuknya yang menyerupai Niagara, lokasi ini mulai sering didatangi pengunjung untuk berwisata.",
            "Jembatan Siti Nurbaya merupakan tempat wisata di Padang yang sangat ikonik. Jembatan ini membentang sepanjang 156 meter di atas Sungai Batang Aru. Pemberian nama Siti Nurbaya sendiri tidak lain karena karena fungsinya sebagai akses penghubung menuju Gunung Padang yang menjadi latar tempat novel klasik Siti Nurbaya. Selain sebagai jalur akses penghubung, jembatan ini biasanya juga dijadikan tempat untuk menikmati panorama matahari terbenam dengan pemandangan Kota Tua Padang.",
            "Masjid Raya Sumatera Barat dikenal dengan arsitekturnya yang unik. Masjid ini tidak memiliki kubah, melainkan menggunakan arsitektur Rumah Gadang dengan empat sudut lancip khas budaya Minangkabau. Bangunan dari Masjid Raya Sumatera Barat ini berbentuk lonjong dengan luas mencapai 18.000 m2.",
            "Pantai Padang merupakan salah satu tempat wisata di Padang terfavorit. Terlebih setelah Pemerintah Kota Padang memoles destinasi ini dengan berbagai fasilitas. Ketika cuaca cerah, Pantai Padang termasuk tempat yang ideal untuk menyaksikan matahari terbenam di ufuk barat dengan bias merahnya yang mengagumkan.",
            "Pantai Air Manis merupakan tempat wisata di Padang yang ikonik. Di pantai ini terdapat sebuah batu yang menyerupai bentuk manusia tengah bersujud. Batu ini diyakini sebagai bentuk Malin Kundang yang dikutuk sang ibu. Salah satu hal yang tak kalah menarik, karena ada juga bebatuan yang berbentuk tali tambang kapal serta kayu yang menyerupai bentuk pecahan badan kapal. Penduduk setempat juga percaya bahwa batu-batuan tersebut tidak hanya sebatas kebetulan, melainkan menjadi bukti jika legenda dari Malin Kundang memang sungguh terjadi.",
            "Pulau Sirandah adalah sebuah pulau yang termasuk dalam wilayah administrasi Kecamatan Bungus Teluk Kabung, Kota Padang. Sirandah berasal dari bahasa Minang yang berarti rendah. Pulau Sirandah merupakan pulau berbukit dengan pantai berpasir putih yang ditumbuhi beberapa jenis pohon tingkat tinggi seperti kelapa, semak dan bakau.",
            "Pulau Pasumpahan berada di sisi barat Pantai Padang dengan luas sekitar 5 hektar. Pasir di Pantai Pulau Pasumpahan berwarna putih, berpadu dengan jernihnya air laut yang berwarna biru sejauh mata memandang. Daya tarik lain yang dimiliki tempat wisata di Padang ini adalah permukaan laut yang seolah terbagi menjadi tiga warna dengan gradasi warna bening, hijau, dan biru jika dilihat dari bibir pantai."
        )

        imagelokasi = arrayOf(
            R.drawable.airterjunlubuakrantiang,
            R.drawable.airterjunlubuaktampuruang,
            R.drawable.airtejublubuakhitam,
            R.drawable.bendunganniagara,
            R.drawable.jamsit,
            R.drawable.masjidraya,
            R.drawable.pantaipadang,
            R.drawable.pantaiairmanis,
            R.drawable.pulausirandah,
            R.drawable.pulaupasumpahan,
        )



        for (i in image.indices) {
            val kuliner = data_model(
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
                deskripsi[i],
            )
            data.add(kuliner)
        }
    }
}