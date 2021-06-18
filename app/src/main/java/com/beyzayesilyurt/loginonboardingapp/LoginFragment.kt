package com.beyzayesilyurt.loginonboardingapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.beyzayesilyurt.loginonboardingapp.databinding.FragmentLoginBinding
import com.beyzayesilyurt.loginonboardingapp.util.viewBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding { FragmentLoginBinding.bind(it) }
    var userNameLogin = ""
    var userPasswordLogin = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editUsername = binding.editTextName
        val editPassword = binding.editTextPassword
        val rememberMe = binding.radioButtonRemember

        val preferences = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val savedUserName = preferences.getString("savedUserName", "")
        editUsername.setText(savedUserName)

        binding.buttonLoginPageLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_startFragment)
        }
        binding.textViewLoginSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        val userNameSignUp = preferences.getString("userNameSignup", "empty")

        binding.buttonLoginPageLogin.setOnClickListener {
            userNameLogin = editUsername.text.toString()
            userPasswordLogin = editPassword.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment2(username = userNameLogin) //pass data from fragment to fragment

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
                preferences.edit().putString("savedUserName", userNameLogin).apply()
                findNavController().navigate(action) //pass data from fragment to fragment
            } else {
                findNavController().navigate(action) //pass data from fragment to fragment
                editUsername.setText("")
                editPassword.setText("")
            }
        }
    }
}