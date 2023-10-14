package com.example.uts

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = intent
        val selectedCinema = intent.getStringExtra("CINEMA")
        val selectedSeatType = intent.getStringExtra("SEAT_TYPE")
        val selectedDate = intent.getStringExtra("DATE")
        val totalPrice = intent.getStringExtra("TOTAL_PRICE")
        val selectedPaymentMethod = intent.getStringExtra("PAYMENT_METHOD")
        val selectedBank = intent.getStringExtra("BANK")
        val accountNumber = intent.getStringExtra("ACCOUNT_NUMBER")

        val cinemaTextView: TextView = findViewById(R.id.cinemaTextView)
        val dateTextView: TextView = findViewById(R.id.dateTextView)
        val seatTextView: TextView = findViewById(R.id.seatTextView)
        val paymentMethodTextView: TextView = findViewById(R.id.paymentMethodTextView)
        val seatPriceTextView: TextView = findViewById(R.id.seatPriceTextView)
        val actualPayTextView: TextView = findViewById(R.id.actualPayTextView)

        cinemaTextView.text = "Cinema : $selectedCinema"
        dateTextView.text = "Date : $selectedDate"
        seatTextView.text = "Seat : $selectedSeatType"
        paymentMethodTextView.text = "Payment Method : $selectedPaymentMethod"
        seatPriceTextView.text = "Total Price : R$totalPrice"
        actualPayTextView.text = "Actual Pay : R$totalPrice"
    }
}


