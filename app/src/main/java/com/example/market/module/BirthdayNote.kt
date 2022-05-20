package com.example.market.module

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "birthday_note_item")
data class BirthdayNote(
    @ColumnInfo(name = "noteUser")
    var noteUser : String,
    @ColumnInfo(name = "pername")
    var perName:String,
    @ColumnInfo(name = "day")
    var day : String,
    @ColumnInfo(name = "month")
    var month : String,
    @ColumnInfo(name = "year")
    var year : String,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
