package com.beyzayesilyurt.loginonboardingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin = findViewById<Button>(R.id.button_main_login)
        buttonLogin.setOnClickListener{
            val route = Intent(this, LoginActivity::class.java)
            startActivity(route)
        }

    }
}