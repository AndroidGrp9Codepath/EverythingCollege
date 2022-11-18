package com.example.mindfulmind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeekHelpAdapter(val therapists: List<Therapist>, private val context: SeekHelpFragment):
    RecyclerView.Adapter<SeekHelpAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val businessImage = itemView.findViewById<ImageView>(R.id.poster)
        val businessNameTextView = itemView.findViewById<TextView>(R.id.businessName)
        val addressTextView = itemView.findViewById<TextView>(R.id.address)
        val phoneNumberTextView = itemView.findViewById<TextView>(R.id.phoneNumber)
        val distanceTextView = itemView.findViewById<TextView>(R.id.distance)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeekHelpAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.help_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: SeekHelpAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val contact: Therapist = therapists[position]
        // Set item views based on your views and data model
        val textView = holder.businessNameTextView
        textView.text = contact.name
    }

    override fun getItemCount(): Int {
        return therapists.size
    }

}
