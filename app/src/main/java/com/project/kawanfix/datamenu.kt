package com.project.kawanfix

class datamenu {
    fun dataInitialize(): ArrayList<data_model> {
        var arrayList = arrayListOf<data_model>()

        var image = arrayOf(
            R.drawable.airterjunlubuakrantiang_xxxhdpi,
            R.drawable.airterjunlubuaktampuruang_xxxhdpi,
            R.drawable.airterjunlubuakhitam_xxxhdpi,
            R.drawable.bendunganniagara_xxxhdpi,
            R.drawable.jamsit_xxxhdpi
        )

        var nama = arrayOf(
            "Air Terjun Lubuak Tampuruang",
            "Air Terjun Lubuak Rantiang",
            "Air Terjun Lubuak Hitam",
            "Bendungan Niagara",
            "Jembatan siti nurbaya",
        )

        var jarak = arrayOf(
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km"
        )

        var imagewaktu = arrayOf(
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock
        )

        var jadwal = arrayOf(
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
        )

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
            )
        )

        val deskripsi = arrayOf(
            "Air Terjun Lubuak Tampuruang berada di Gunung Sarik, Kuranji, Padang. Lubuak Tampuruang terdiri dari air terjun kecil dari sungai yang mengalir tidak terlalu deras. Lubuak Tampuruang berasal dari kata Lubuak yang berarti kolam alami dan Tampuruang yang berarti batok kelapa. Nama ini diambil karena bentuk air terjun yang kecil dan sungainya hampir membentuk setengah lingkaran seperti batok kelapa.",
            "Lubuak Rantiang merupakan tempat wisata di Padang berupa air terjun yang memiliki kolam di aliran sungainya. Lokasinya berada di daerah Sungai Bangek. Meskipun hanya setinggi 6 meter, namun air terjun yang dikenal dengan Lubuak Ngalauan, atau Sarasah Lubuak Rantiang ini menyuguhkan panorama indah. Belum lagi dilengkapi dengan air berwarna kehijauan bening yang sangat menyegarkan untuk berenang.",
            "Air Terjun Lubuk Hitam secara administratif berada di Kelurahan Teluk Kabung Utara, Kecamatan Bungus Teluk Kabung. Air terjun ini memiliki tiga tingkatan yang indah. Ketinggian masing-masing air terjun dimulai sekitar 2 meter, 10 meter, dan 20 meter.",
            "Pulau Sirandah adalah sebuah pulau yang termasuk dalam wilayah administrasi Kecamatan Bungus Teluk Kabung, Kota Padang. Sirandah berasal dari bahasa Minang yang berarti rendah. Pulau Sirandah merupakan pulau berbukit dengan pantai berpasir putih yang ditumbuhi beberapa jenis pohon tingkat tinggi seperti kelapa, semak dan bakau.",
            "Tempat wisata di Padang berikutnya adalah Bendungan Niagara Koto Pulai. Sesuai namanya, bendungan ini memiliki bentuk layaknya air terjun niagara. Lokasinya berada di Koto Pulai, Kecamatan Koto Tangah, Kota Padang. Awalnya, Bendungan Koto Pulai ini bukanlah tempat wisata, namun karena keindahan pemandangan dan bentuknya yang menyerupai Niagara, lokasi ini mulai sering didatangi pengunjung untuk berwisata."
        )

        val imagelokasi = arrayOf(
            R.drawable.airterjunlubuaktampuruang,
            R.drawable.airterjunlubuakrantiang,
            R.drawable.airtejublubuakhitam,
            R.drawable.pulausirandah,
            R.drawable.bendunganniagara,
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
                deskripsi[i],
            )
            arrayList.add(wisata)
        }
        return arrayList
    }

    fun dataInitialize_kuliner(): ArrayList<data_model> {
        var arrayList_kuliner = arrayListOf<data_model>()

        var image = arrayOf(
            R.drawable.esdurianikogantinyo_xxxhdpi,
            R.drawable.katupekpitalahpurus3_xxxhdpi,
            R.drawable.satedd_xxxhdpi,
            R.drawable.pauhpiamanxxxhdpi,
            R.drawable.warungkopinanyo_xxxhdpi
        )

        var nama = arrayOf(
            "Es durian iko gantinyo",
            "Katupek pitalah purus 3",
            "Sate danguang-daguang",
            "Rumah Makan pauh piaman",
            "Warung kopi nan yo",
        )

        var jarak = arrayOf(
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km",
            "5.0 Km"
        )

        var imagewaktu = arrayOf(
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock,
            R.drawable.ic_ic_clock
        )

        var jadwal = arrayOf(
            "Buka",
            "Buka",
            "Buka",
            "Buka",
            "Buka"
        )

        var imagelokasi = arrayOf(
            R.drawable.esdurianikogantinyo,
            R.drawable.katupek_pitalah,
            R.drawable.satedd,
            R.drawable.rumah_makanpiaman,
            R.drawable.warungkopinanyo,
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
                    jadwalbuka = "10.00 - 21.000"
                )
            ),
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
            )
        )


        val deskripsi = arrayOf(
            "Pilihan kuliner Es Durian lainnya yang bisa Toppers coba saat berkunjung ke Padang adalah Es Durian Iko Gantinyo. Tempat ini juga populer sebagai tempat nongkrong para pecinta kuliner durian di Padang. Selain Es Durian, tersedia juga menu sate padang dan juga pempek sebagai pendamping Es Durian yang kamu pesan.",
            "Katupek pitalah merupakan makanan khas daerah Pitalah yang ada di Padang. Restoran yang paling terkenal dengan menu ini adalah restoran Katupek Pitalah Purus 3. Makanan ini berisi potongan ketupat dengan siraman kuah kuning yang berisi nangka dan rebung. Beroperasi mulai pagi hari, makanan ini cocok sebagai menu sarapanmu. Selain katupek pitalah, restoran ini juga menyediakan pical, bubur hitam, dan juga nasi goreng.",
            "Ke Padang tanpa mencoba wisata kuliner sate padang tentu tidakak akan afdol. Salah satu tempat berburu sate padang paling terkenal di Padang adalah Sate Danguang-Danguang. Dengan kuah saus sate padang yang khas dan daging sapi yang gurih, sate padang daguang-daguang menjadi spot wisata kuliner favorit di Padang.",
            "Rumah makan Pauh Piaman adalah rumah makan Padang yang pas untuk merasakan bagaimana rasanya menikmati nasi Padang di Kota Padang. Hidangan favorit dari tempat ini adalah gulai kepala ikan yang diolah dengan rempah-rempah khas masakan Padang.",
            "Kota Padang memiliki warung kopi legendaris dengan nuansa pecinan tempo dulu. Tujuan wisata kuliner ini paling sering dikunjungi pada saat pagi hari untuk sarapan. Menu andalan dari kedai kopi ini adalah Kopi Es dan juga mie goreng."
        )

        for (i in image.indices) {
            val Kuliner = data_model(
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
            arrayList_kuliner.add(Kuliner)
        }
        return arrayList_kuliner
    }
}