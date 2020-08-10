package com.codingwithjks.notepad.ui.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.codingwithjks.notepad.ui.Database.NoteDatabase
import com.codingwithjks.notepad.ui.Model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteRepository {

    companion object
    {
        private var noteDatabase:NoteDatabase?=null

        private fun initialiseDB(context: Context):NoteDatabase?
        {
            return  NoteDatabase.getInstance(context)
        }

        fun insert(context: Context,note: Note)
        {
            noteDatabase= initialiseDB(context)

            CoroutineScope(IO).launch {
                noteDatabase?.getDao()?.insert(note)
            }
        }

        fun getCardData(context: Context):LiveData<List<Note>>?
        {
            noteDatabase= initialiseDB(context)
            return noteDatabase?.getDao()?.getCardsData()
        }
        fun update(context:Context,note:Note)
        {
            noteDatabase= initialiseDB(context)

            CoroutineScope(IO).launch {
                noteDatabase?.getDao()?.update(note)
            }
        }

        fun search(context: Context,data:String):LiveData<List<Note>>?
        {
            noteDatabase= initialiseDB(context)
            return noteDatabase?.getDao()?.search(data)
        }

        fun delete(context: Context,note:Note){
            noteDatabase= initialiseDB(context)
            CoroutineScope(IO).launch {
                noteDatabase?.getDao()?.delete(note)
            }
        }


    }


}