package com.example.mindfulmind

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mindfulmind.databinding.ActivityAboutAppBinding
import com.example.mindfulmind.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class AboutAppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutAppBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val linkTV = findViewById<TextView>(R.id.linkTV)


        linkTV.setOnClickListener {
            val Urlgit = "https://github.com/AndroidGrp9Codepath/MindfulMind"
            val browseIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Urlgit))
            startActivity(browseIntent)


        }
    }
}