package com.example.myfirstapp.pagerouting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.R

class RegisterPage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page2)
        findViewById<Button>(R.id.saveBtn).setOnClickListener {
            val intent = Intent(this@RegisterPage2, HomePage::class.java)
            startActivity(intent)
        }
    }
}