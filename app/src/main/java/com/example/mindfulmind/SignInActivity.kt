package com.example.mindfulmind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mindfulmind.databinding.ActivitySignInBinding
import com.example.mindfulmind.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //hide action bar
        supportActionBar?.hide()

        //this init Firebase
        firebaseAuth = FirebaseAuth.getInstance()
        // the below button sends the user to sign up activity
        binding.SignUpTextView.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        //this btn sign the user in
        binding.SignInBtn.setOnClickListener {
            val emailEditText  = binding.UsernameEmailEditText.text.toString()
            val pWEditText = binding.passwordEditText.text.toString()


            if (emailEditText.isNotEmpty() && pWEditText.isNotEmpty() ) {

                    firebaseAuth.signInWithEmailAndPassword(emailEditText,pWEditText).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this,MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

            } else {
                Toast.makeText(this,"Empty Fields are not allow!!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser != null ) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}