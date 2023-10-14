package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var movieImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var movieDescriptionTextView: TextView
    private lateinit var movieRatingBar: RatingBar
    private lateinit var buyTicketButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movieImageView = findViewById(R.id.movieImageView)
        movieTitleTextView = findViewById(R.id.movieTitleTextView)
        movieDescriptionTextView = findViewById(R.id.movieDescriptionTextView)
        movieRatingBar = findViewById(R.id.movieRatingBar)
        buyTicketButton = findViewById(R.id.buyTicketButton)

        val movieTitle = intent.getStringExtra("title")
        val movieDescription = intent.getStringExtra("description")
        val movieRating = intent.getFloatExtra("rating", 0.0f)

        movieTitleTextView.text = movieTitle
        movieDescriptionTextView.text = movieDescription
        movieRatingBar.rating = movieRating
        // Sumber gambar dapat disesuaikan dengan gambar film yang sesuai
        movieImageView.setImageResource(R.drawable.movie1)

        buyTicketButton.setOnClickListener {
            // Pindah ke TicketActivity
            val intent = Intent(this, TicketActivity::class.java)
            // Anda dapat menyertakan data tambahan ke TicketActivity di sini
            startActivity(intent)
        }
    }
}
