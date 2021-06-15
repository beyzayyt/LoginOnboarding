package com.beyzayesilyurt.loginonboardingapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.beyzayesilyurt.loginonboardingapp.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    var userName = ""
    var userPassword = ""
    var userRetypePassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var sharedPreferences =
            this.getSharedPreferences("com.beyzayesilyurt.loginonboardingapp", Context.MODE_PRIVATE)
                .edit()

        val userNameSignup = binding.textViewSignupUsernam
        val userPasswordSignup = binding.textViewSignupPassword
        val userRetypeSignup = binding.textViewSignupRetypepassword

        binding.imageButtonSignupBack.setOnClickListener {
            val route = Intent(this, LoginActivity::class.java)
            startActivity(route)
        }

        binding.buttonSignup.setOnClickListener {
            userName = userNameSignup.text.toString()
            userPassword = userPasswordSignup.text.toString()
            userRetypePassword = userRetypeSignup.text.toString()

            if (userNameSignup.text.isNullOrEmpty()) {
                userNameSignup.requestFocus()
                userNameSignup.error = "Field can not be left blank"
            } else if (userRetypeSignup.text.isNullOrEmpty() || userPasswordSignup.text.isNullOrEmpty()) {
                userPasswordSignup.requestFocus()
                userPasswordSignup.error = "Field can not be left blank"

            } else if (userPasswordSignup.text.isNullOrEmpty()) {
                userPasswordSignup.requestFocus()
                userPasswordSignup.error = "Field can not be left blank"
            } else if (userRetypeSignup.text.isNullOrEmpty()) {
                userRetypeSignup.requestFocus()
                userRetypeSignup.error = "Field can not be left blank"
            } else {
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