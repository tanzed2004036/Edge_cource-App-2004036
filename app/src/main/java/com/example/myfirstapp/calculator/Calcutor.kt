package com.example.myfirstapp.calculator

import androidx.activity.enableEdgeToEdge
import com.example.myfirstapp.R
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.collections.mutableListOf
import kotlin.math.min

//import com.udojava.evalex.Expression


class Calcutor : AppCompatActivity() {
    lateinit var btnadd: Button
    lateinit var btnsub: Button
    lateinit var btnmul: Button
    lateinit var btndiv: Button
    lateinit var btn0: Button
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btnCE: Button
    lateinit var btnBs: Button
    lateinit var btnEql: Button
    lateinit var tvdisp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_calcutor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        btnadd = findViewById(R.id.btnPls)
        btnsub = findViewById(R.id.btnMin)
        btnmul = findViewById(R.id.btnMul)
        btndiv = findViewById(R.id.btnDiv)

        btn0 = findViewById(R.id.btn0)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnCE = findViewById(R.id.btnCE)
        btnBs = findViewById(R.id.btnBS)
        btnEql = findViewById(R.id.btnEql)
        tvdisp = findViewById(R.id.tvDisp)


        var fromEqual = false
        fun eval(str: String): String {
            // Replace unsupported operators with supported ones
            val sanitizedStr = str.replace("*", "×").replace("/", "÷")

            // Split the sanitized string into numbers using regex
            val numbers = sanitizedStr.split("[+\\-÷×]".toRegex()).toMutableList()

            // Handle negative numbers at the beginning
            if (sanitizedStr[0] == '-') {
                numbers[0] = "-" + numbers[1]
                numbers.removeAt(1) // Remove the next number after merging
            }

            return try {
                when {
                    sanitizedStr.contains('+') -> (numbers[0].toDouble() + numbers[1].toDouble()).toString()
                    sanitizedStr.contains('-') -> (numbers[0].toDouble() - numbers[1].toDouble()).toString()
                    sanitizedStr.contains('×') -> (numbers[0].toDouble() * numbers[1].toDouble()).toString()
                    sanitizedStr.contains('÷') -> (numbers[0].toDouble() / numbers[1].toDouble()).toString()
                    else -> "0"
                }
            } catch (e: Exception) {
                // Handle any errors during evaluation
                "Error: ${e.message}"
            }
        }


        fun evaluateExpression(expression: String): String {
            return eval(expression).toDouble().toString()
        }

        fun pressBtn(btnName: Int) {
            Log.d("Disp", tvdisp.text.toString())
            if (tvdisp.text == "0") {
                tvdisp.text = btnName.toString()
            } else {
                if (!(tvdisp.text.length > 9)) tvdisp.append(btnName.toString())
            }


            if (tvdisp.text.length > 5) {
                tvdisp.textSize = (100f - tvdisp.text.length * 5)
                Log.d("size", tvdisp.textSize.toString())
            } else if (tvdisp.textSize < 135) {
                tvdisp.textSize = (100f + tvdisp.text.length * 5)
                Log.d("size", tvdisp.textSize.toString())
            }
            if (tvdisp.text != "0" && fromEqual) {
                tvdisp.text = "0"
                fromEqual = false
            }
        }

        btn0.setOnClickListener {
            if (tvdisp.text != "0") {
                tvdisp.append("0")
            }
        }
        btn1.setOnClickListener {
            pressBtn(1)
        }
        btn2.setOnClickListener {
            pressBtn(2)
        }
        btn3.setOnClickListener {
            pressBtn(3)
        }
        btn4.setOnClickListener {
            pressBtn(4)
        }
        btn5.setOnClickListener {
            pressBtn(5)
        }
        btn6.setOnClickListener {
            pressBtn(6)
        }
        btn7.setOnClickListener {
            pressBtn(7)
        }
        btn8.setOnClickListener {

            pressBtn(8)
        }
        btn9.setOnClickListener {
            pressBtn(9)
        }
        btnBs.setOnClickListener {

            if (tvdisp.text.length == 1) {
                tvdisp.text = "0"
            } else {
                tvdisp.text = tvdisp.text.dropLast(1)
            }
            tvdisp.textSize = min(100f, ((8 - tvdisp.text.length) * 2f + 60f))
            Log.d("size", tvdisp.textSize.toString())
            if (tvdisp.textSize < 135) {
            }
        }
        btnCE.setOnClickListener {
            tvdisp.text = "0"
            tvdisp.setTextSize(100f)
        }

        btnadd.setOnClickListener {
            tvdisp.append("+")
            fromEqual = false
        }
        btnsub.setOnClickListener {
            tvdisp.append("-")
            fromEqual = false
        }
        btnmul.setOnClickListener {
            tvdisp.append("*")
            fromEqual = false
        }
        btndiv.setOnClickListener {
            tvdisp.append("/")
            fromEqual = false
        }

        btnEql.setOnClickListener {
            tvdisp.text = evaluateExpression(tvdisp.text.toString())
            if (tvdisp.text.takeLast(2).toString() == ".0") {//reducing .0 at last
                tvdisp.text = tvdisp.text.dropLast(2)
//                tvdisp.text = "P"
            }
//                tvdisp.text = tvdisp.text.takeLast(2)
            fromEqual = true
//        Log.d(tvdisp.textSize.toString(),"M")
        }
        //accommodate all digits::
    }

}