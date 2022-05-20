package com.example.market.ROOM_DATA

class UserRepository(private val dp:UserDatabase) {

    suspend fun insert(item : User_item) = dp.getUserDao().insert(item)
    suspend fun delete(item: User_item) = dp.getUserDao().delete(item)
    fun getAllUserItem() = dp.getUserDao().getAllUserItems()
    suspend fun searchUser(searchUsername: String) = dp.getUserDao().searchUser(searchUsername)

}