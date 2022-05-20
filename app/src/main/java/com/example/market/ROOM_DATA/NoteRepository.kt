package com.example.market.ROOM_DATA

import com.example.market.module.BirthdayNote

class NoteRepository(private val db:NoteDatabase) {

    suspend fun insert(note: BirthdayNote) = db.getNoteDao().insert(note)
    suspend fun delete(note: BirthdayNote) = db.getNoteDao().delete(note)
    fun getAllNote() = db.getNoteDao().getAllBirthdayNote()
}