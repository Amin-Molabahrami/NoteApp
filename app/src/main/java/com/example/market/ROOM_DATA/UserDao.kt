package com.example.market.ROOM_DATA

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : User_item)

    @Delete
    suspend fun delete(item: User_item)

    @Query("SELECT * FROM user_item")
    fun getAllUserItems() : LiveData<List<User_item>>

    @Query("SELECT * FROM user_item WHERE itemUsername LIKE :searchUsername")
    suspend fun searchUser(searchUsername:String):User_item

}