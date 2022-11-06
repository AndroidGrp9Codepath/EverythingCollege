package com.example.mindfulmind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JournalAdapter(private val context: Context, private val journals: List<DisplayJournals>) :
RecyclerView.Adapter<JournalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.journal_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val journal = journals[position]
        holder.bind(journal)
    }

    override fun getItemCount() = journals.size
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        private val journalentryTextview = itemView.findViewById<TextView>(R.id.journalEntryTV)
        private val journalTitleTextview = itemView.findViewById<TextView>(R.id.journaltitleTextV)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val quote = journals[absoluteAdapterPosition]
        }

        fun bind(journal: DisplayJournals) {
            journalentryTextview.text = journal.journalEntry
            journalTitleTextview.text = journal.journalTitle

        }


    }
}