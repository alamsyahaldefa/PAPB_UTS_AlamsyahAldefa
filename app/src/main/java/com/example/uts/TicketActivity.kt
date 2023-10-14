package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TicketActivity : AppCompatActivity() {
    private lateinit var cinemaSpinner: Spinner
    private lateinit var seatTypeSpinner: Spinner
    private lateinit var datePicker: DatePicker
    private lateinit var totalPriceTextView: TextView
    private lateinit var paymentMethodSpinner: Spinner
    private lateinit var bankSpinner: Spinner
    private lateinit var accountNumberEditText: EditText
    private lateinit var orderSummaryButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        cinemaSpinner = findViewById(R.id.cinemaSpinner)
        seatTypeSpinner = findViewById(R.id.seatTypeSpinner)
        datePicker = findViewById(R.id.datePicker)
        totalPriceTextView = findViewById(R.id.totalPriceTextView)
        paymentMethodSpinner = findViewById(R.id.paymentMethodSpinner)
        bankSpinner = findViewById(R.id.bankSpinner)
        accountNumberEditText = findViewById(R.id.accountNumberEditText)
        orderSummaryButton = findViewById(R.id.orderSummaryButton)

        val cinemas = arrayOf("Jogja City Mall", "Sleman City hall", "Pakuwon mall")
        val seatTypes = arrayOf("Regular", "VIP", "Executive")
        val paymentMethods = arrayOf("Credit Card", "Debit Card", "Cash")
        val banks = arrayOf("BNI", "BCA", "Mandiri", "BRI")

        ArrayAdapter(this, android.R.layout.simple_spinner_item, cinemas).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            cinemaSpinner.adapter = it
        }

        ArrayAdapter(this, android.R.layout.simple_spinner_item, seatTypes).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            seatTypeSpinner.adapter = it
        }

        ArrayAdapter(this, android.R.layout.simple_spinner_item, paymentMethods).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            paymentMethodSpinner.adapter = it
        }

        ArrayAdapter(this, android.R.layout.simple_spinner_item, banks).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            bankSpinner.adapter = it
        }

        seatTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                updateSeatPrice(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        orderSummaryButton.setOnClickListener {
            navigateToOrderSummary()
        }
    }

    private fun updateSeatPrice(position: Int) {
        val seatPrices = arrayOf(35_000, 50_000, 75_000)
        val selectedSeatPrice = seatPrices[position]
        totalPriceTextView.text = "Total Harga: Rp ${selectedSeatPrice}"
    }

    private fun navigateToOrderSummary() {
        // Ambil data dari komponen-komponen yang diisi di TicketActivity
        val selectedCinema = cinemaSpinner.selectedItem.toString()
        val selectedSeatType = seatTypeSpinner.selectedItem.toString()
        val selectedDate = "${datePicker.dayOfMonth}/${datePicker.month + 1}/${datePicker.year} "
        val totalPrice = totalPriceTextView.text.toString().substring(14)
        val selectedPaymentMethod = paymentMethodSpinner.selectedItem.toString()
        val selectedBank = bankSpinner.selectedItem.toString()
        val accountNumber = accountNumberEditText.text.toString()

        // Pindah ke OrderActivity dengan membawa data-data tersebut
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("CINEMA", selectedCinema)
        intent.putExtra("SEAT_TYPE", selectedSeatType)
        intent.putExtra("DATE", selectedDate)
        intent.putExtra("TOTAL_PRICE", totalPrice)
        intent.putExtra("PAYMENT_METHOD", selectedPaymentMethod)
        intent.putExtra("BANK", selectedBank)
        intent.putExtra("ACCOUNT_NUMBER", accountNumber)
        startActivity(intent)
    }
}

