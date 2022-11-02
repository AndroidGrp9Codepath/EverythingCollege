package com.example.mindfulmind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mindfulmind.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        firebaseAuth = FirebaseAuth.getInstance()

        //define fragments
        val quotesFragment: Fragment = QuoteListFragment()
        val calmMusicFragment: Fragment = CalmMusicFragment()
        val journalFragment: Fragment = JournalFragment()
        val seekHelpFragment: Fragment = SeekHelpFragment()

        val bottomNavegation : BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavegation.itemIconTintList = null

        // handle navigation selection
        bottomNavegation.setOnClickListener { item ->
            lateinit var fragment: Fragment
            when (item.id) {
                R.id.nav_quotes -> fragment = quotesFragment
                R.id.nav_calm_music -> fragment = calmMusicFragment
                R.id.nav_Journal -> fragment = journalFragment
                R.id.nav_Seek_help -> fragment = seekHelpFragment
            }
            replaceFragment(fragment)
            true
        }

        bottomNavegation.selectedItemId = R.id.nav_quotes

        val addJournalBtn = findViewById<FloatingActionButton>(R.id.addJournalBtn)

        addJournalBtn.setOnClickListener {
            val intent = Intent(this,addJournalActivity::class.java)
            startActivity(intent)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_top_navegation,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.top_nav_Button -> {
            // User chose the "Settings" item, show the app settings UI...
            val intent = Intent(this,AboutAppActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.top_nav_logout_btn -> {

            //logout
            firebaseAuth.signOut()
            // User chose the "Settings" item, show the app settings UI...
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.top_nav_Profile -> {

            // User chose the "Settings" item, show the app settings UI...
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
    private fun replaceFragment(AllFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.quote_frame_layout, AllFragment)
        fragmentTransaction.commit()
    }


}