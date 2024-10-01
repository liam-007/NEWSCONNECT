package com.example.newsapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.R

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading) // This is your loading XML layout

        // Delay for 3 seconds (3000 milliseconds) before switching to the About Page
        android.os.Handler().postDelayed({
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            finish() // Close LoadingActivity after switching to AboutActivity
        }, 3000) // 3 seconds delay
    }
}
