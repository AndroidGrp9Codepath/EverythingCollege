package com.example.mindfulmind

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CalmMusicAdapter(private val songs: List<MusicItem>, private val context: CalmMusicFragment) : RecyclerView.Adapter<CalmMusicAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val artists = itemView.findViewById<TextView>(R.id.artists)
        val songName = itemView.findViewById<TextView>(R.id.songName)
        val play = itemView.findViewById<ImageView>(R.id.play)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalmMusicAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val musicView = inflater.inflate(R.layout.calm_music_item, parent, false)
        // Return a new holder instance
        return ViewHolder(musicView)
    }

    override fun onBindViewHolder(viewHolder: CalmMusicAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val song: MusicItem = songs[position]
        // Set item views based on your views and data model
        val textView = viewHolder.songName
        textView.text = song.songName

        viewHolder.play.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(song.preview_url))
            startActivity(it.context, browserIntent, null)
        }



    }

    override fun getItemCount(): Int {
        return songs.size
    }
}