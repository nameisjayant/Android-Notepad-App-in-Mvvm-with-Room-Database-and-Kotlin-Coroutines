package com.codingwithjks.notepad.ui.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codingwithjks.notepad.ui.Dao.NoteDao
import com.codingwithjks.notepad.ui.Model.Note

@Database(entities = [Note::class],version = 2,exportSchema = false)
abstract class NoteDatabase : RoomDatabase()
{
    abstract fun getDao():NoteDao

    companion object{
        private const val DATABASE_NAME="NoteDatabase"

        @Volatile
        var instance:NoteDatabase?=null

        fun getInstance(context: Context):NoteDatabase?
        {
            if(instance == null)
            {
                synchronized(NoteDatabase::class.java)
                {
                    if(instance == null)
                    {
                        instance= Room.databaseBuilder(context,NoteDatabase::class.java,
                            DATABASE_NAME).build()
                    }
                }
            }

            return instance
        }
    }
}