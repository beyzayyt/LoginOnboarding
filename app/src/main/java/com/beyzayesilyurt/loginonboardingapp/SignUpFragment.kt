package com.beyzayesilyurt.loginonboardingapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.beyzayesilyurt.loginonboardingapp.databinding.FragmentSignUpBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.beyzayesilyurt.loginonboardingapp.util.viewBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private val binding by viewBinding { FragmentSignUpBinding.bind(it) }

    var userName = ""
    var userPassword = ""
    var userRetypePassword = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preference = requireActivity().getSharedPreferences("pref",Context.MODE_PRIVATE)

        val userNameSignup = binding.textViewSignupUsernam
        val userPasswordSignup = binding.textViewSignupPassword
        val userRetypeSignup = binding.textViewSignupRetypepassword

        binding.imageButtonSignupBack.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        binding.buttonSignup.setOnClickListener {
            userName = userNameSignup.text.toString()
            userPassword = userPasswordSignup.text.toString()
            userRetypePassword = userRetypeSignup.text.toString()

            if (userNameSignup.text.isNullOrEmpty()) {
                userNameSignup.requestFocus()
                userNameSignup.error = "Field can not be left blank!"
            } else if (userRetypeSignup.text.isNullOrEmpty() || userPasswordSignup.text.isNullOrEmpty()) {
                userPasswordSignup.requestFocus()
                userPasswordSignup.error = "Field can not be left blank!"
            } else if (userPasswordSignup.text.isNullOrEmpty()) {
                userPasswordSignup.requestFocus()
                userPasswordSignup.error = "Field can not be left blank!"
            } else if (userRetypeSignup.text.isNullOrEmpty()) {
                userRetypeSignup.requestFocus()
                userRetypeSignup.error = "Field can not be left blank!"
            } else {
                preference.edit().putString("userNameSignup", userName).apply()
                preference.edit().putString("userPasswordSignup", userPassword).apply()
                preference.edit().putString("userRetypeSignup", userRetypePassword).apply()
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            }
        }
    }
}