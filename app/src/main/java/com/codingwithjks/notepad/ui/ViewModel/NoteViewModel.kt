package com.codingwithjks.notepad.ui.ViewModel

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codingwithjks.notepad.ui.Model.Note
import com.codingwithjks.notepad.ui.Repository.NoteRepository

class NoteViewModel : ViewModel(){

    fun insert(context:Context,note:Note)
    {
        NoteRepository.insert(context,note)
    }

    fun getCardsData(context: Context):LiveData<List<Note>>?
    {
        return NoteRepository.getCardData(context)
    }

    fun update(context:Context,note:Note)
    {
        NoteRepository.update(context,note)
    }

    fun search(context: Context,data:String):LiveData<List<Note>>?
    {
        return NoteRepository.search(context,data)
    }

    fun delete(context: Context,note: Note)
    {
        NoteRepository.delete(context,note)
    }
}