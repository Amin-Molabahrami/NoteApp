package com.example.market.ROOM_DATA

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.market.module.BirthdayNote
import java.io.Serializable

@Entity(tableName = "user_item")
data class User_item(
    @ColumnInfo(name = "itemUsername")
    var itemUsername:String ,
    @ColumnInfo(name = "itemPassword")
    var itemPassword: String,
) :Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}
