package com.example.myfirstapp // Ensure this matches your package name

import android.app.Activity
import android.os.Bundle

class CalculatorActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator) // Make sure this layout file exists
    }
}


// clean code architecture
// clean code programming book