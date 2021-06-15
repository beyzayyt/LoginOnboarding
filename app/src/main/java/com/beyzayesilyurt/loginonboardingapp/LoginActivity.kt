package com.beyzayesilyurt.loginonboardingapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.beyzayesilyurt.loginonboardingapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    var userNameLogin = ""
    var userPasswordLogin = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val sharedPreferences =
            this.getSharedPreferences("com.beyzayesilyurt.loginonboardingapp", MODE_PRIVATE)

        val editUsername = binding.editTextName
        val editPassword = binding.editTextPassword
        val rememberMe = binding.radioButtonRemember

        val savedUserName = sharedPreferences.getString("savedUserName", "")
        editUsername.setText(savedUserName)

        binding.buttonLoginPageLogin.setOnClickListener {
            val route = Intent(this, MainActivity::class.java)
            startActivity(route)
        }

        binding.textViewLoginSignup.setOnClickListener {
            val route1 = Intent(this, SignUpActivity::class.java)
            startActivity(route1)
        }

        val userNameSignUp = sharedPreferences.getString("userNameSignup", "empty")
       //val userPasswordSignUp = sharedPreferences.getString("userPasswordSignup", "empty")

        binding.buttonLoginPageLogin.setOnClickListener {
            userNameLogin = editUsername.text.toString()
            userPasswordLogin = editPassword.text.toString()

            if (editUsername.text.isNullOrEmpty()) {
                editUsername.requestFocus()
                editUsername.error = "Field can not be left blank"
            } else if (editPassword.text.isNullOrEmpty()) {
                editPassword.requestFocus()
                editPassword.error = "Field can not be left blank"
            } else if (userNameSignUp != userNameLogin) {
                editUsername.requestFocus()
                editUsername.error = "can not paired"
            } else if (rememberMe.isChecked) {
                sharedPreferences.edit().putString("savedUserName", userNameLogin).apply()
                val route = Intent(this, HomeActivity::class.java)
                startActivity(route)
            } else {
                val route = Intent(this, HomeActivity::class.java)
                startActivity(route)
                editUsername.setText("")
                editPassword.setText("")
            }
        }



    }
}