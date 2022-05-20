package com.example.market.ROOM_DATA

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.market.module.BirthdayNote


@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:BirthdayNote)

    @Delete
    suspend fun delete(note: BirthdayNote)

    @Query("SELECT * FROM birthday_note_item")
    fun getAllBirthdayNote(): LiveData<List<BirthdayNote>>
}