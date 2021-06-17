package com.beyzayesilyurt.loginonboardingapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.beyzayesilyurt.loginonboardingapp.databinding.FragmentStartBinding
import com.beyzayesilyurt.loginonboardingapp.util.viewBinding

class StartFragment : Fragment(R.layout.fragment_start) {
    private val binding by viewBinding { FragmentStartBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMainLogin.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_loginFragment)
        }
    }
}