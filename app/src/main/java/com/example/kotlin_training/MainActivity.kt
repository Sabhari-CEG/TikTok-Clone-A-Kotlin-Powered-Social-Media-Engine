package com.example.kotlin_training

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,
                    "Please enter both username and password",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (username == "admin" && password == "admin") {
                Toast.makeText(this,
                    "Successfully logged in",
                    Toast.LENGTH_SHORT).show()

                // Create and start the intent to move to HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

                // Optional: finish the current activity so user can't go back
                finish()
            } else {
                Toast.makeText(this,
                    "Invalid credentials",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}