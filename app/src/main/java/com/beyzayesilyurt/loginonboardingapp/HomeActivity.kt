package com.beyzayesilyurt.loginonboardingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var sharedPreferences =
            this.getSharedPreferences("com.beyzayesilyurt.loginonboardingapp", MODE_PRIVATE)
        var homeTitle = findViewById<TextView>(R.id.textview_home_title)
        val userNameSignUp = sharedPreferences.getString("userNameSignup", "empty")
//        homeTitle.text = userNameSignUp
        homeTitle.text = getString(R.string.welcome_user, userNameSignUp)

    }
}