package com.example.mindfulmind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class addJournalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_journal)


        val saveJournalButton =findViewById<Button>(R.id.saveJournalBtn)

        saveJournalButton.setOnClickListener {
            val journalEntryEditText = findViewById<EditText>(R.id.journalEntryET).text.toString()
            val journalTitleEditText = findViewById<EditText>(R.id.tittleEditText).text.toString()

            lifecycleScope.launch(IO) {
                (application as JournalApplication).db.journalDao().insert(
                    JournalEntity(journalEntryEditText,journalTitleEditText)
                )
            }
            finish()
        }
    }
}