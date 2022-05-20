package com.example.market.BirthdayFragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.market.R
import com.example.market.ROOM_DATA.*
import com.example.market.adapter.BirthdayNoteAdapter
import com.example.market.databinding.ListbirthFragmentBinding
import com.example.market.module.BirthdayNote

class ListBirthdayFragment:Fragment(R.layout.listbirth_fragment) {

    lateinit var binding: ListbirthFragmentBinding
    lateinit var noteViewModel : NoteViewModel
    lateinit var _adapter: BirthdayNoteAdapter
    private lateinit var user1 : User_item
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ListbirthFragmentBinding.bind(view)
        val repository = NoteRepository(NoteDatabase(requireContext()))
        val noteViewModelFactory = NoteViewModelFactory(repository)
        noteViewModel = ViewModelProvider(this,noteViewModelFactory).get(NoteViewModel::class.java)
        arguments?.let { bundle ->
            user1 = bundle.getParcelable("user1")!!
        }
        user1 = User_item("amin.969","85811380")
        var noteList = ArrayList<BirthdayNote>()
        noteViewModel.getAllNote()
        noteViewModel.NoteLiveList.observe(viewLifecycleOwner, Observer {
            noteList = it as ArrayList<BirthdayNote>
        })
        val notelist1 = ArrayList<BirthdayNote>()
        for(x in noteList){
            if(x.noteUser.equals(user1.itemUsername)){
                notelist1.add(x)
            }
        }
        _adapter = BirthdayNoteAdapter(notelist1)
        binding.rvListbirth.apply {
            adapter = _adapter
            layoutManager = LinearLayoutManager(context)
        }
        binding.addNoteBtn.setOnClickListener{
            val bundle = bundleOf("useradd" to user1)
            view.findNavController().navigate(R.id.addBirthdayNote,bundle)
        }

    }
}