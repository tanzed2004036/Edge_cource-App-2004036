package com.example.myfirstapp.viewmodelclass

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.R

class FrenchOpenGameActivity : AppCompatActivity() {
    private lateinit var tvTeamOneScore: TextView
    private lateinit var tvTeamTwoScore: TextView

    private var teamOneScore = 0;
    private var teamTwoScore = 0;
    private var federwins = 0
    private var nadalwins = 0
    private var total_matches = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_french_open_game)
        tvTeamOneScore = findViewById(R.id.tvFederScore)
        tvTeamTwoScore = findViewById(R.id.tvNadalScore)

        if (savedInstanceState != null) {
            teamOneScore = savedInstanceState.getInt("teamOneScore")
            teamTwoScore = savedInstanceState.getInt("teamTwoScore")
        }

        // Set the initial score
        tvTeamOneScore.text = teamOneScore.toString()
        tvTeamTwoScore.text = teamTwoScore.toString()

        // Set the click listeners
        findViewById<Button>(R.id.button).setOnClickListener {
            teamOneScore++
            tvTeamOneScore.text = teamOneScore.toString()
            checkWinnder()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            teamTwoScore++
            tvTeamTwoScore.text = teamTwoScore.toString()
            checkWinnder()
        }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("teamOneScore", teamOneScore)
        outState.putInt("teamTwoScore", teamTwoScore)
    }

    private fun checkWinnder() {
        if (teamOneScore == 10 || teamTwoScore == 10) {
            if (teamOneScore > teamTwoScore) {
                showToast("Federer wins the match")
                teamOneScore = 0
                teamTwoScore = 0
                tvTeamOneScore.text = teamOneScore.toString()
                tvTeamTwoScore.text = teamTwoScore.toString()
                total_matches++
                federwins++
            } else {
                showToast("Nadal wins the match")
                teamOneScore = 0
                teamTwoScore = 0
                tvTeamOneScore.text = teamOneScore.toString()
                tvTeamTwoScore.text = teamTwoScore.toString()
                total_matches++
                nadalwins++
            }
            if (total_matches == 3) {
                if (federwins > nadalwins) {
                    showToast("Federer wins Tournament")
                } else {
                    showToast("Nadal wins Tournament")
                }
                total_matches = 0
            }
        }

    }

    private fun showToast(s: String) {
        // show toast message
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}