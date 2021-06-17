package com.beyzayesilyurt.loginonboardingapp

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.beyzayesilyurt.loginonboardingapp.databinding.FragmentHomeBinding
import com.beyzayesilyurt.loginonboardingapp.util.viewBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding { FragmentHomeBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preference = requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE)
        val userNameSignUp = preference.getString("userNameSignup", "empty")
        binding.textviewHomeTitle.text = getString(R.string.welcome_user, userNameSignUp)
    }
}