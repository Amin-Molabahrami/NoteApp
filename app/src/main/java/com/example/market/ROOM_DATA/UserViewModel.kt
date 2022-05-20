package com.example.market.ROOM_DATA

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository):ViewModel() {

    val livedata = MutableLiveData<User_item>()

    fun insert(item : User_item) {
        viewModelScope.launch {
            repository.insert(item)
        }
    }
    fun delete(item: User_item) {
        viewModelScope.launch {
            repository.delete(item)
        }
    }
    fun getAllUserItem() {
        viewModelScope.launch {
            repository.getAllUserItem()
        }
    }
    fun searchUser(searchUsername: String) {
        viewModelScope.launch{
            livedata.postValue(repository.searchUser(searchUsername))
        }

    }

}