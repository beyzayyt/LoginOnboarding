package com.beyzayesilyurt.loginonboardingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beyzayesilyurt.loginonboardingapp.databinding.ActivityBaseBinding
import com.beyzayesilyurt.loginonboardingapp.util.viewBinding

class BaseActivity : AppCompatActivity() {
    private val binding by viewBinding { ActivityBaseBinding.inflate(it) }

    /*private lateinit var navController: NavController*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*setupNavigation()*/
    }
    /*private fun setupNavigation() {
        navController = findNavController(R.id.fragment_base_container)
    }*/
}