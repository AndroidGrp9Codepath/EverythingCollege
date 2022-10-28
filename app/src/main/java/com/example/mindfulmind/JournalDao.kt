package com.example.mindfulmind

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal_table")
    fun getAll(): Flow<List<JournalEntity>>

    @Insert
    fun insertAll(journal: List<JournalEntity>)

    @Insert
    fun insert(journal: JournalEntity)

    @Query("DELETE FROM journal_table")
    fun removeAll()

    @Delete
    fun delete(journal: JournalEntity)
}