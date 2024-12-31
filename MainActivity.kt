package org.geeksforgeeks.quizapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Setting up things
    private lateinit var falseButton: Button
    private lateinit var trueButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var image: ImageView
    private lateinit var questionTextView: TextView

    private var correct = 0
    private var currentQuestionIndex = 0 // To keep track of the current question

    private val questionBank = arrayOf(
        Question(R.string.a, true),
        Question(R.string.b, false),
        Question(R.string.c, true),
        Question(R.string.d, true),
        Question(R.string.e, true),
        Question(R.string.f, false)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setting up the buttons associated with IDs
        falseButton = findViewById(R.id.false_button)
        trueButton = findViewById(R.id.true_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.answer_text_view)
        image = findViewById(R.id.myimage)

        // Register our buttons to listen to click events
        falseButton.setOnClickListener(this)
        trueButton.setOnClickListener(this)
        nextButton.setOnClickListener(this)
        prevButton.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(v: View) {
        when (v.id) {
            R.id.false_button -> checkAnswer(false)
            R.id.true_button -> checkAnswer(true)
            R.id.next_button -> {
                // Go to the next question
                if (currentQuestionIndex < questionBank.size) {
                    currentQuestionIndex++
                    if (currentQuestionIndex == questionBank.size) {
                        questionTextView.text = getString(R.string.correct, correct)
                        nextButton.visibility = View.INVISIBLE
                        prevButton.visibility = View.INVISIBLE
                        trueButton.visibility = View.INVISIBLE
                        falseButton.visibility = View.INVISIBLE

                        if (correct > 3) {
                            questionTextView.text = "CORRECTNESS IS $correct OUT OF 6"
                        } else {
                            image.setImageResource(R.drawable.resu)
                        }
                    } else {
                        updateQuestion()
                    }
                }
            }
            R.id.prev_button -> {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.size
                    updateQuestion()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun updateQuestion() {
        Log.d("Current", "onClick: $currentQuestionIndex")

        // Setting the TextView with the new question
        questionTextView.text = getString(questionBank[currentQuestionIndex].answerResId)
        when (currentQuestionIndex) {
            1 -> image.setImageResource(R.drawable.f2)
            2 -> image.setImageResource(R.drawable.f3)
            3 -> image.setImageResource(R.drawable.f4)
            4 -> image.setImageResource(R.drawable.f5)
            5 -> image.setImageResource(R.drawable.f6)
            6 -> image.setImageResource(R.drawable.f7)
            7 -> image.setImageResource(R.drawable.f1)
        }
    }

    private fun checkAnswer(userChooseCorrect: Boolean) {
        val answerIsTrue = questionBank[currentQuestionIndex].answerTrue
        val toastMessageId = if (userChooseCorrect == answerIsTrue) {
            correct++
            R.string.correct_answer
        } else {
            R.string.wrong_answer
        }

        Toast.makeText(this, toastMessageId, Toast.LENGTH_SHORT).show()
    }
}
