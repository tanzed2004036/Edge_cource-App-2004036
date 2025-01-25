package com.example.myfirstapp.pagerouting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.R

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page)
        findViewById<Button>(R.id.nextButton).setOnClickListener {
            val intent = Intent(this@RegisterPage, RegisterPage2::class.java)
            startActivity(intent)
        }
    }
}