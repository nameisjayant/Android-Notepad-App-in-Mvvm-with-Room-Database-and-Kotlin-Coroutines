package com.codingwithjks.notepad.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingwithjks.notepad.R
import com.codingwithjks.notepad.ui.Listener.Listener
import com.codingwithjks.notepad.ui.Model.Note

class NoteAdapter(private val context: Context,private var noteList:ArrayList<Note>,private val listener: Listener) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun getItemCount(): Int =noteList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       val note=noteList[position]
        holder.data.text=note.data
        holder.date.text=note.date
    }

    fun setData(noteList: ArrayList<Note>)
    {
     this.noteList=noteList
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val data:TextView=itemView.findViewById(R.id.data)
        val date:TextView=itemView.findViewById(R.id.date)

        init {
            itemView.setOnClickListener {
                listener.onClickListener(adapterPosition)
            }
        }
    }
}