package com.example.hungerwoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hungerwoosh.databinding.ActivitySignBinding
import com.example.hungerwoosh.model.UserModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

private const val TAG = "SignActivity"
class SignActivity : AppCompatActivity() {
    private val binding: ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var username: String
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        databaseReference = Firebase.database.reference

        binding.btnCreateAccount.setOnClickListener {
            checkInputs()
        }

        binding.tvAlreadyHaveAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun checkInputs() {
        email = binding.etEmail.text.toString().trim()
        password = binding.etPassword.text.toString().trim()
        username = binding.etName.text.toString()

        if(email.isBlank() || password.isBlank() || username.isBlank()) {
            Toast.makeText(this, "Please Fill All Details", Toast.LENGTH_SHORT).show()
        } else {
            createAccount()
        }
    }

    private fun createAccount() {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful) {
                saveUserData()
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Failure Account Creation ", task.exception)
            }
        }
    }

    private fun saveUserData() {
        val user = UserModel(username, email, password)
        val userId = auth.currentUser!!.uid
        databaseReference.child("user").child(userId).setValue(user)
    }
}