package com.example.mindfulmind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(private val context: Context, private val quotes: List<DisplayJournals>) :
RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quotes_items,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes[position]
        holder.bind(quote)
    }

    override fun getItemCount() = quotes.size
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener{
        private val profileImageView = itemView.findViewById<ImageView>(R.id.profilePicImageView)
        private val usernameTextview = itemView.findViewById<TextView>(R.id.usernameTextView)
        private val quotesTextview = itemView.findViewById<TextView>(R.id.quoteTextview)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val quote = quotes[absoluteAdapterPosition]
        }

        fun bind(quote: DisplayJournals) {
            usernameTextview.text = quote.username
            quotesTextview.text = quote.quotes
        }


    }
}