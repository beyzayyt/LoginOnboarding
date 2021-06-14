package com.beyzayesilyurt.loginonboardingapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class SignUpActivity : AppCompatActivity() {
    var userName = ""
    var userPassword = ""
    var userRetypePassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var sharedPreferences =
            this.getSharedPreferences("com.beyzayesilyurt.loginonboardingapp", Context.MODE_PRIVATE)
                .edit()

        val userNameSignup = findViewById<EditText>(R.id.textView_signup_usernam)
        val userPasswordSignup = findViewById<EditText>(R.id.textView_signup_password)
        val userRetypeSignup = findViewById<EditText>(R.id.textView_signup_retypepassword)

        val backButtonSignup = findViewById<ImageButton>(R.id.imageButton_signup_back)
        backButtonSignup.setOnClickListener {
            val route = Intent(this, LoginActivity::class.java)
            startActivity(route)
        }

        val buttonSignup = findViewById<Button>(R.id.button_signup)
        buttonSignup.setOnClickListener {
            userName = userNameSignup.text.toString()
            userPassword = userPasswordSignup.text.toString()
            userRetypePassword = userRetypeSignup.text.toString()

            if (userNameSignup.text.isNullOrEmpty()) {
                userNameSignup.requestFocus()
                userNameSignup.error = "Field can not be left blank"
            } else if (userRetypeSignup.text.isNullOrEmpty() ||userPasswordSignup.text.isNullOrEmpty() ) {
                userPasswordSignup.requestFocus()
                userPasswordSignup.error = "Field can not be left blank"

            } else if (userPasswordSignup.text.isNullOrEmpty()) {
                userPasswordSignup.requestFocus()
                userPasswordSignup.error = "Field can not be left blank"
            } else if (userRetypeSignup.text.isNullOrEmpty()) {
                userRetypeSignup.requestFocus()
                userRetypeSignup.error = "Field can not be left blank"
            }
            else {
                sharedPreferences.putString("userNameSignup", userName)
                sharedPreferences.putString("userPasswordSignup", userPassword)
                sharedPreferences.putString("userRetypeSignup", userRetypePassword)
                sharedPreferences.apply()

                val route = Intent(this, LoginActivity::class.java)
                startActivity(route)
            }
        }
    }
}