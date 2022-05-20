package com.example.market

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.market.ROOM_DATA.*
import com.example.market.databinding.LoginFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.login_fragment) {
    lateinit var binding: LoginFragmentBinding
    lateinit var userViewModel: UserViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginFragmentBinding.bind(view)
        val repository = UserRepository(UserDatabase(requireContext()))
        val userViewModelFactory = UserViewModelFactory(repository)
        userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
        binding.LoginBtn2.setOnClickListener {

            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()


            userViewModel.searchUser(username)
            userViewModel.livedata.observe(viewLifecycleOwner, Observer {
                if (username.equals(it.itemUsername)) {
                    if (it.itemPassword.equals(password)) {
                        Toast.makeText(activity, "Login successful", Toast.LENGTH_SHORT).show()
                        val bundle = Bundle()
                        bundle.putSerializable("user",it)
                        view.findNavController().navigate(R.id.noteFragment,bundle)
                    } else {
                        Toast.makeText(activity, "Wrong Password", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(activity, "Username not found", Toast.LENGTH_SHORT).show()
                }
            })

        }
        binding.cancelBtnLogin.setOnClickListener {
            view.findNavController().navigate(R.id.loginAndRegisterFragment)
        }
    }
}