package com.example.mindfulmind

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class QuoteAdapter(private val context: Context, private val quotes: List<Quotes>) :
RecyclerView.Adapter<QuoteAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quotes_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes[position]
        holder.bind(quote)
    }

    override fun getItemCount() = quotes.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val profileImageView = itemView.findViewById<ImageView>(R.id.profilePicImageView)
        private val usernameextView = itemView.findViewById<TextView>(R.id.usernameTextView)
        private val quoteTextView = itemView.findViewById<TextView>(R.id.quoteTextview)
        private val authorTextView = itemView.findViewById<TextView>(R.id.authorTextview)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(quote: Quotes) {

            quoteTextView.text = quote.quote
            authorTextView.text = quote.author


//            Glide.with(context)
//                .load(quote.mediaImageUrl)
//                .into(mediaImageView)
        }

        override fun onClick(v: View?) {
            // Get selected article
            val quote = quotes[absoluteAdapterPosition]

            // Navigate to Details screen and pass selected article
//            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra(ARTICLE_EXTRA, article)
//            context.startActivity(intent)
        }
    }
}