package com.example.market

import android.os.Bundle
import android.service.autofill.UserData
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.market.ROOM_DATA.*
import com.example.market.databinding.RegisterFragmentBinding
import com.example.market.module.BirthdayNote

class RegisterFragment:Fragment(R.layout.register_fragment) {

    lateinit var binding : RegisterFragmentBinding
    lateinit var userViewModel: UserViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = RegisterFragmentBinding.bind(view)
        val repository = UserRepository(UserDatabase(requireContext()))
        val userViewModelFactory = UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this,userViewModelFactory).get(UserViewModel::class.java)
        binding.registerBtn2.setOnClickListener {

            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            val confirmPass = binding.editTextConfirmPassword.text.toString()

            if(username.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()){

                if(!password.equals(confirmPass)){
                    Toast.makeText(activity, "Wrong confirm password ", Toast.LENGTH_SHORT).show()
                }

                if(password.equals((confirmPass))){
                    val user = User_item(username,password)
                    userViewModel.insert(user)
                    Toast.makeText(activity, "Enter data successful", Toast.LENGTH_SHORT).show()
                    view.findNavController().navigate(R.id.loginFragment)
                }
            }
            else{
                Toast.makeText(activity, "Please enter all the data", Toast.LENGTH_SHORT).show()
            }
        }
        binding.cancelBtnRegister.setOnClickListener {
            view.findNavController().navigate(R.id.loginAndRegisterFragment)
        }
    }


}