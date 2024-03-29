package com.example.market.ROOM_DATA

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User_item::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

    companion object{
        @Volatile
        private var instance : UserDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(context,UserDatabase::class.java,"User.dp").build()
    }


}