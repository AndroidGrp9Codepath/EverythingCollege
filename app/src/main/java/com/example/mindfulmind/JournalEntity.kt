package com.example.mindfulmind

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal_table")
data class JournalEntity (

    @ColumnInfo(name = "journalEntry") val journalEntry: String?,
//    @ColumnInfo(name = "username") val username: String?,
    @PrimaryKey(autoGenerate = true) val id: Long= 0,

)