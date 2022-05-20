package com.example.market.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.market.R
import com.example.market.module.BirthdayNote

class BirthdayNoteAdapter(var noteList : ArrayList<BirthdayNote>) : RecyclerView.Adapter<BirthdayNoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val personname = itemView.findViewById<TextView>(R.id.txtPersonName)
        val day = itemView.findViewById<TextView>(R.id.txtDay)
        val month = itemView.findViewById<TextView>(R.id.txtMonth)
        val year = itemView.findViewById<TextView>(R.id.txtYear)
        val delete = itemView.findViewById<ImageView>(R.id.deleteIcon)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.birthday_note_item,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList.get(position)
        holder.apply {
            personname.text = note.perName
            day.text = note.day.toString()
            month.text = note.month.toString()
            year.text = note.year.toString()
            delete.setOnClickListener {
                noteList.remove(note)
            }
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}