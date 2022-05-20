package com.example.market.ROOM_DATA

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.market.module.BirthdayNote
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository):ViewModel() {

    val NoteLiveList = MutableLiveData<LiveData<List<BirthdayNote>>>()

    fun insert(note: BirthdayNote){
        viewModelScope.launch {
            repository.insert(note)
        }
    }
    fun delete(note: BirthdayNote){
        viewModelScope.launch {
            repository.delete(note)
        }
    }
    fun getAllNote(){
        NoteLiveList.postValue(repository.getAllNote())
    }
}