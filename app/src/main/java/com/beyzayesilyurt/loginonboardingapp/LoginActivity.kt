package com.beyzayesilyurt.loginonboardingapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    var userNameLogin = ""
    var userPasswordLogin = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var sharedPreferences =
            this.getSharedPreferences("com.beyzayesilyurt.loginonboardingapp", MODE_PRIVATE)

        val editUsername = findViewById<EditText>(R.id.editText_name)
        val editPassword = findViewById<EditText>(R.id.editText_password)
        val rememberMe = findViewById<RadioButton>(R.id.radioButton_remember)

        var savedUserName = sharedPreferences.getString("savedUserName", "")
        editUsername.setText(savedUserName)

        val buttonLogin = findViewById<ImageButton>(R.id.imageButton_login_back)
        buttonLogin.setOnClickListener {
            val route = Intent(this, MainActivity::class.java)
            startActivity(route)
        }

        val textSignup = findViewById<TextView>(R.id.textView_login_signup)
        textSignup.setOnClickListener {
            val route1 = Intent(this, SignUpActivity::class.java)
            startActivity(route1)
        }

        val login = findViewById<Button>(R.id.button_loginPage_login)

        val userNameSignUp = sharedPreferences.getString("userNameSignup", "empty")
       //val userPasswordSignUp = sharedPreferences.getString("userPasswordSignup", "empty")

        login.setOnClickListener {
            userNameLogin = editUsername.text.toString()
            userPasswordLogin = editPassword.text.toString()

            if (editUsername.text.isNullOrEmpty()) {
                editUsername.requestFocus()
                editUsername.error = "Field can not be left blank"
            } else if (editPassword.text.isNullOrEmpty()) {
                editPassword.requestFocus()
                editPassword?.error = "Field can not be left blank"
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