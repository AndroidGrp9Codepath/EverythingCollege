package com.example.mindfulmind

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mindfulmind.databinding.ActivitySignInBinding
import com.example.mindfulmind.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

private const val TAG = "SingUpActivity/"

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

//    private val emailEditText  = binding.UsernameEmailEditText.text.toString()
//    private  val pWEditText = binding.passwordEditText.text.toString()
//    private  val confirmPWET = binding.ReenterPasswordEditText.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //hide action bar
        supportActionBar?.hide()


        //this init Firebase
        firebaseAuth = FirebaseAuth.getInstance()

        // the below textview sends the user to sign in activity
        binding.hasAnAccountTextView.setOnClickListener {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }

        //this btn create an user account and adds it to firebase DataBase
        binding.SignUpBtn.setOnClickListener {
//            checkCredentials()

            val emailEditText  = binding.UsernameEmailEditText.text.toString()
            val pWEditText = binding.passwordEditText.text.toString()
            val confirmPWET = binding.ReenterPasswordEditText.text.toString()



            if (emailEditText.isNotEmpty() && pWEditText.isNotEmpty() && confirmPWET.isNotEmpty()) {
                if (pWEditText == confirmPWET){

                    firebaseAuth.createUserWithEmailAndPassword(emailEditText,pWEditText).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this,SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Log.e(TAG, "Failed to create account ")
                    Toast.makeText(this,"Passwords did not match",Toast.LENGTH_SHORT).show()

                }
            } else {
                Log.e(TAG, "Failed to create account 2")
                Toast.makeText(this,"Empty Fields are not allow!!",Toast.LENGTH_SHORT).show()
            }
        }

    }

//    fun checkCredentials(){
//        val String_email = emailEditText
//        val StringpWEditText = pWEditText
//        val StringconfirmPWET = confirmPWET
//
//        if (String_email.isEmpty() || !String_email.contains("@")){
//            showError(emailEditText,"Email is not valid")
//        }
//        else if (StringpWEditText.isEmpty() || StringpWEditText.length < 6 ){
//            showError(pWEditText,"Password must be 6 charathers")
//        }
//        else if (StringconfirmPWET.isEmpty() || !StringconfirmPWET.equals(StringpWEditText)){
//            showError(confirmPWET,"Password does not match")
//        }else {
//            Toast.makeText(this,"call registration method",Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun showError(input: String, s: String) {
//        Toast.makeText(this,input + s,Toast.LENGTH_SHORT).show()
//
//
//    }
}