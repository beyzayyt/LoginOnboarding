package com.beyzayesilyurt.loginonboardingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.beyzayesilyurt.loginonboardingapp.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var sharedPreferences =
            this.getSharedPreferences("com.beyzayesilyurt.loginonboardingapp", MODE_PRIVATE)

        val userNameSignUp = sharedPreferences.getString("userNameSignup", "empty")
        binding.textviewHomeTitle.text = getString(R.string.welcome_user, userNameSignUp)


    }
}