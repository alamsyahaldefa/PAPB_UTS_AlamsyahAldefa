package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            // Check credentials (For simplicity, no actual authentication logic is implemented)
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Assuming credentials are correct, move to HomeActivity
            if (isCredentialsValid(username, password)) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            }
            // TODO: Handle incorrect credentials case (show a message, etc.)
        }
    }

    private fun isCredentialsValid(username: String, password: String): Boolean {
        // For simplicity, consider it valid if username and password are not empty
        return username.isNotEmpty() && password.isNotEmpty()
    }
}

