package com.example.myfirstapp.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.R

class AnimationDemoActivity : AppCompatActivity() {
    lateinit var btnAction: Button
    lateinit var ivImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animation_demo)
        btnAction = findViewById<Button>(R.id.btnAction)
        ivImage = findViewById<ImageView>(R.id.ivImage)

        btnAction.setOnClickListener {
            fadeOutAnimationExample()
        }
    }

    private fun fadeOutAnimationExample() {
        val fadeAnimation = ObjectAnimator.ofFloat(ivImage, "alpha", 0.2f, 0f)
    }
}
