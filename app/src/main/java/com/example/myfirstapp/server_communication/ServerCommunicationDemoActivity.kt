package com.example.myfirstapp.server_communication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.R

class ServerCommunicationDemoActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_server_communication_demo)
        val tvResult = findViewById<TextView>(R.id.tvCom)

    }
}