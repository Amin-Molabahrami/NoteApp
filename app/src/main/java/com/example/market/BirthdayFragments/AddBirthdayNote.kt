package com.example.market.BirthdayFragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.market.R
import com.example.market.ROOM_DATA.*
import com.example.market.databinding.AddBirthdaynoteFragmentBinding
import com.example.market.module.BirthdayNote

class AddBirthdayNote:Fragment(R.layout.add_birthdaynote_fragment) {

    lateinit var binding: AddBirthdaynoteFragmentBinding
    private lateinit var user2: User_item
    lateinit var noteViewModel : NoteViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AddBirthdaynoteFragmentBinding.bind(view)
        val repository = NoteRepository(NoteDatabase(requireContext()))
        val noteViewModelFactory = NoteViewModelFactory(repository)
        noteViewModel = ViewModelProvider(this,noteViewModelFactory).get(NoteViewModel::class.java)
        binding.AddBtn.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val day = binding.editTextDay.toString()
            val month = binding.editTextMonth.toString()
            val year = binding.editTextYear.toString()
            arguments?.let { bundle ->
                user2 = bundle.getParcelable("useradd")!!
            }
            if(name.isNotEmpty()&&day.isNotEmpty()&&month.isNotEmpty()&&year.isNotEmpty()){
                val note = BirthdayNote(user2.itemUsername,name,day,month,year)
                noteViewModel.insert(note)
            }
            else{
                Toast.makeText(activity, "Please enter all the data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}