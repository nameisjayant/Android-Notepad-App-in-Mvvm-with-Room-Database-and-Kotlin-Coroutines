package com.codingwithjks.notepad.ui.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import com.codingwithjks.notepad.R
import com.codingwithjks.notepad.ui.Model.Note
import com.codingwithjks.notepad.ui.ViewModel.NoteViewModel

import kotlinx.android.synthetic.main.activity_update.*
import java.util.*

class UpdateActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    private lateinit var date:Date
    private lateinit var  getNote:Note
    private lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        getDate()
        noteViewModel= NoteViewModel()
        updateCharacter.text="| 0 characters"
         updateNote.addTextChangedListener(textWatcher)

        val bundle:Bundle?=intent.extras
        if(bundle != null){
           getNote = bundle.getSerializable("note") as Note
        }
        loadNote(getNote)
        updateData.setOnClickListener {
            updateNote()
        }
    }

    private fun loadNote(note :Note)
    {
        updateNote.setText(note.data)
        updateCharacter.text="${note.characters}"
    }

    private fun updateNote()
    {
        getNote.data=updateNote.text.toString()
        getNote.date=updateDate.text.toString()
        getNote.characters=updateNote.text.toString().length.toLong()
        noteViewModel.update(applicationContext,getNote)
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    private val textWatcher= object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            updateCharacter.text= " | Character "+s?.length.toString()

        }

    }


    private fun getDate() {
        date= Calendar.getInstance().time
        updateDate.text=date.toString()
    }



}