package com.example.myfirstapp.signup


import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.R

class SignUp : AppCompatActivity() {
    lateinit var namefield: EditText
    lateinit var addressfield: EditText
    lateinit var otherfield: EditText
    lateinit var zipfield: EditText
    lateinit var genderfield: RadioButton
    lateinit var emailfield: EditText
    lateinit var passfield: EditText
    lateinit var confirmfield: EditText
    lateinit var marketingfield: Switch
    lateinit var checkboxfield: CheckBox
    lateinit var submitbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        namefield = findViewById(R.id.FormInputFName)
        addressfield = findViewById(R.id.FormInputAddress1)
        otherfield = findViewById(R.id.FormInputAddress2)
        zipfield = findViewById(R.id.FormInputZip)
        genderfield = findViewById(R.id.radioButtonMale)
        emailfield = findViewById(R.id.FormInputEmail)
        passfield = findViewById(R.id.FormInputPass)
        confirmfield = findViewById(R.id.FormInputConfirmPass)
        marketingfield = findViewById(R.id.SwitchMarketing)
        checkboxfield = findViewById(R.id.CheckboxTerms)
        submitbutton = findViewById(R.id.ButtonSignup)

        var name = namefield.text.toString()
        var address = addressfield.text.toString()
        var other = otherfield.text.toString()
        var zip = zipfield.text.toString()
        var gender = genderfield.text.toString()
        var email = emailfield.text.toString()
        var pass = passfield.text.toString()
        var confirm = confirmfield.text.toString()
        var marketing = marketingfield.text.toString()
        var checkbox = checkboxfield.text.toString()


    }
}