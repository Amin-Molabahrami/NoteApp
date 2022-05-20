package com.example.market

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.market.databinding.FirstpageFragmentBinding

class LoginAndRegisterFragment: Fragment(R.layout.firstpage_fragment) {

    lateinit var binding: FirstpageFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FirstpageFragmentBinding.bind(view)
        binding.loginBtn1.setOnClickListener {
            view.findNavController().navigate(R.id.loginFragment)
        }
        binding.registerBtn1.setOnClickListener {
            view.findNavController().navigate(R.id.registerFragment)
        }
    }
}