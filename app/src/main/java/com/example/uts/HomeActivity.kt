package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var usernameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Inisialisasi usernameTextView
        usernameTextView = findViewById(R.id.usernameTextView)

        // Setelah mendapatkan data username dari intent, simpan ke dalam usernameTextView
        val username = intent.getStringExtra("username")
        usernameTextView.text = "Hello, $username"


        // Inisialisasi elemen UI
        usernameTextView = findViewById(R.id.usernameTextView)
        val welcomeTextView: TextView = findViewById(R.id.welcomeTextView)
        val topMoviesTextView: TextView = findViewById(R.id.topMoviesTextView)

        // Movie 1
        val movieTitle1: TextView = findViewById(R.id.movieTitle1)
        val movieRatingBar1: RatingBar = findViewById(R.id.movieRatingBar1)
        val buyTicketButton1: ImageButton = findViewById(R.id.buyTicketButton1)

        // Movie 2
        val movieTitle2: TextView = findViewById(R.id.movieTitle2)
        val movieRatingBar2: RatingBar = findViewById(R.id.movieRatingBar2)
        val buyTicketButton2: ImageButton = findViewById(R.id.buyTicketButton2)

        // Movie 3
        val movieTitle3: TextView = findViewById(R.id.movieTitle3)
        val movieRatingBar3: RatingBar = findViewById(R.id.movieRatingBar3)
        val buyTicketButton3: ImageButton = findViewById(R.id.buyTicketButton3)

        // Movie 4
        val movieTitle4: TextView = findViewById(R.id.movieTitle4)
        val movieRatingBar4: RatingBar = findViewById(R.id.movieRatingBar4)
        val buyTicketButton4: ImageButton = findViewById(R.id.buyTicketButton4)



        // Menambahkan listener ke tombol untuk membuka DetailActivity
        buyTicketButton1.setOnClickListener {
            openDetailActivity("PETUALANGAN SHERINA 2", "Salah satu film musikal legendaris Indonesia, Petualangan Sherina, akhirnya resmi akan memulai perjalanan sekuelnya, Petualangan Sherina 2. " +
                    "Film yang digarap oleh Miles Film dan Base Entertainment ini akan memulai produksinya minggu depan.",5.0)
        }

        buyTicketButton2.setOnClickListener {
            openDetailActivity("DI AMBANG KEMATIAN", "Cerita film Di Ambang Kematian ini diadopsi dari kisah nyata yang diambil dari sebuah utas viral dalam platform X. Utas dari akun @Jeropoint " +
                    "itu bercerita tentang seorang gadis yang terancam menjadi tumbal pesugihan ayahnya sendiri.", 4.5)
        }

        buyTicketButton3.setOnClickListener {
            openDetailActivity("WAKTU MAGHRIB", "Waktu Maghrib menceritakan tentang kekesalan Adi dan Saman yang selalu dimarahi oleh Bu Woro di sekolah, sebab keduanya sering terlambat masuk.",
                4.0
            )
        }

        buyTicketButton4.setOnClickListener {
            openDetailActivity("SLEEP CALL", "SLEEP CALL diperankan oleh aktris dan aktor hebat seperti Laura Basuki sebagai bintang utama yang " +
                    "beradu akting dengan Bio One.", 3.5)
        }
    }

    private fun openDetailActivity(title: String, description: String, rating: Double) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("description", description)
        intent.putExtra("rating", rating)
        startActivity(intent)
    }
}

