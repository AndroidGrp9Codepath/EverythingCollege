package com.example.mindfulmind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }
}