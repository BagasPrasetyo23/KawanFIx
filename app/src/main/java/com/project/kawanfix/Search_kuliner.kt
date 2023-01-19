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

class Search_kuliner : AppCompatActivity() {

    private lateinit var adapter: AdapterVertical
    private lateinit var recyclerView: RecyclerView
    private lateinit var data: ArrayList<data_model>

    lateinit var image:Array<Int>
    lateinit var nama:Array<String>
    lateinit var jarak:Array<String>
    lateinit var imagewaktu:Array<Int>
    lateinit var jadwal:Array<String>
    lateinit var deskripsi :Array<String>
    lateinit var imagelokasi:Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen(window)
        LightStatusBar(window)
        setContentView(R.layout.activity_search_kuliner)

        val back : ImageButton = findViewById(R.id.back)
        back.setOnClickListener{
            finish()
        }
        dataInitialize()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.recyclerviewKuliner)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterVertical(data)
        recyclerView.adapter = adapter

        val editText : EditText = findViewById(R.id.et_kuliner)

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
            R.drawable.esdurianikogantinyo_xxxhdpi,
            R.drawable.katupekpitalahpurus3_xxxhdpi,
            R.drawable.satedd_xxxhdpi,
            R.drawable.warungkopinanyo_xxxhdpi,
            R.drawable.esduriangantinanlamo_xxxhdpi,
            R.drawable.kulinerjembatansnb_xxxhdpi,
            R.drawable.pauhpiamanxxxhdpi,
            R.drawable.lamunombakxxxhdpi
        )

        nama = arrayOf(
            "Es durian iko gantinyo",
            "Katupek pitalah purus 3",
            "Sate daguang-danguang",
            "Warung kopi nan yo",
            "Es durian ganti nan lamo",
            "Kuliner jembatan siti nurbaya",
            "Rumah makan pauh piaman",
            "rumah makan lamun ombak"
        )

        jarak = arrayOf(
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
            "Buka"
        )

        val fasilitas = listOf<List<data_model.Fasilitas>>(
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
                ),
                data_model.Fasilitas(
                    dot = R.drawable.ic_dot,
                    ket = "Toilet"
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
                    jadwalbuka = "06.00 - 11.00"
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
                    hari = "Senin - Minggu",
                    jadwalbuka = "06.00 - 17.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "10.00 - 22.00"
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
                    hari = "Senin - Minggu",
                    jadwalbuka = "08.00 - 21.00"
                )
            ),
            listOf<data_model.Operasional>(
                data_model.Operasional(
                    hari = "Senin - Minggu",
                    jadwalbuka = "10.00 - 21.000"
                )
            )
        )

        val cards = listOf<List<data_model.Card>>(
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_ice_cream,
                    textcard = "Harga mulai dari",
                    hargacard = "Rp 10.000"
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
                    imagecard = R.drawable.ic_sate,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 17.000"
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
                    imagecard = R.drawable.ic_ice_cream,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 10.000"
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
                    imagecard = R.drawable.ic_food,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 19.500"
                )
            ),
            listOf<data_model.Card>(
                data_model.Card(
                    imagecard = R.drawable.ic_food,
                    textcard = "Harga Mulai dari",
                    hargacard = "Rp 30.000"
                )
            ),
        )
        val imagesliders = listOf<List<data_model.Imageslider>>(
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
                    images = R.drawable.esduriangantinanlamo_xxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.gantinanlamo2
                ),
                data_model.Imageslider(
                    images = R.drawable.gantinanlamo3
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
                    images = R.drawable.lamunombakxxxhdpi
                ),
                data_model.Imageslider(
                    images = R.drawable.lamunombak2
                ),
                data_model.Imageslider(
                    images = R.drawable.lamunombak3
                ),
            ),
        )

        deskripsi = arrayOf(
            "Pilihan kuliner Es Durian lainnya yang bisa Toppers coba saat berkunjung ke Padang adalah Es Durian Iko Gantinyo. Tempat ini juga populer sebagai tempat nongkrong para pecinta kuliner durian di Padang. Selain Es Durian, tersedia juga menu sate padang dan juga pempek sebagai pendamping Es Durian yang kamu pesan.",
            "Katupek pitalah merupakan makanan khas daerah Pitalah yang ada di Padang. Restoran yang paling terkenal dengan menu ini adalah restoran Katupek Pitalah Purus 3. Makanan ini berisi potongan ketupat dengan siraman kuah kuning yang berisi nangka dan rebung. Beroperasi mulai pagi hari, makanan ini cocok sebagai menu sarapanmu. Selain katupek pitalah, restoran ini juga menyediakan pical, bubur hitam, dan juga nasi goreng.",
            "Ke Padang tanpa mencoba wisata kuliner sate padang tentu tidakak akan afdol. Salah satu tempat berburu sate padang paling terkenal di Padang adalah Sate Danguang-Danguang. Dengan kuah saus sate padang yang khas dan daging sapi yang gurih, sate padang daguang-daguang menjadi spot wisata kuliner favorit di Padang.",
            "Kota Padang memiliki warung kopi legendaris dengan nuansa pecinan tempo dulu. Tujuan wisata kuliner ini paling sering dikunjungi pada saat pagi hari untuk sarapan. Menu andalan dari kedai kopi ini adalah Kopi Es dan juga mie goreng.",
            "Sehabis menikmati santap kuliner Padang, saatnya menikmati hidangan pencuci mulut. Es Durian Ganti Nan Lamo adalah tujuan wisata kuliner Padang yang tepat untuk kamu penggemar buah durian. Berdiri sejak 1960, cita rasa dari es durian di tempat ini masih terjaga dan tetap digemari.",
            "Jembatan Siti Nurbaya memang terkenal sebagai tujuan wisata, namun pada malam hari, tempat ini berubah menjadi tujuan wisata kuliner Padang kaki lima yang terkenal akan sajian jagung bakar dan juga pisang kapiak. Suasana malam jembatan ditemani temaram lampu jalanan tentu akan membuat hidangan menjadi semakin lezat.",
            "Rumah makan Pauh Piaman adalah rumah makan Padang yang pas untuk merasakan bagaimana rasanya menikmati nasi Padang di Kota Padang. Hidangan favorit dari tempat ini adalah gulai kepala ikan yang diolah dengan rempah-rempah khas masakan Padang.",
            "Pilihan tempat merasakan lezatnya nasi Padang adalah Restoran Lamun Ombak. Disini Kamu bisa menemukan menu lengkap mulai dari rendang, asam padeh, gulai otak, dendeng balado, hingga ayam pop. Dengan citarasa yang lezat, tujuan wisata kuliner Padang satu ini tak pernah sepi pengunjung."
        )

        imagelokasi = arrayOf(
            R.drawable.esdurianikogantinyo,
            R.drawable.katupek_pitalah,
            R.drawable.satedd,
            R.drawable.warungkopinanyo,
            R.drawable.esduriangantinanlamo,
            R.drawable.kuliner_jembatansitinurbaya,
            R.drawable.rumah_makanpiaman,
            R.drawable.lamunombakxxxhdpi,
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
                deskripsi[i]
            )
            data.add(kuliner)
        }
    }
}