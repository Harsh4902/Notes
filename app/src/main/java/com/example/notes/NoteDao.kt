package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert( note: Note)

    @Delete
    fun delete( note: Note)

    @Query("SELECT * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>

}