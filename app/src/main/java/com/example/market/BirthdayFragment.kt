package com.example.market

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.market.ROOM_DATA.User_item
import com.example.market.databinding.BirthdayFragmentBinding

class BirthdayFragment : Fragment(R.layout.birthday_fragment) {

    lateinit var binding: BirthdayFragmentBinding
    lateinit var user1 : User_item
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = BirthdayFragmentBinding.bind(view)
        val fragment = view.findViewById(R.id.fragment_birthday) as View
        binding.bottomnavigation.setupWithNavController(fragment.findNavController())
        arguments?.let { bundle ->
            user1 = bundle.getSerializable("user") as User_item
        }
        val bundle =Bundle()
        bundle.putSerializable("user1",user1)
        view.findNavController().navigate(R.id.listBirthdayFragment3,bundle)

    }
}