package com.example.newsapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class StartActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        // Check if the user is currently logged in
        if (auth.currentUser != null) {
            // If the user is already logged in, go to NewsActivity
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // If the user is not logged in, go to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
