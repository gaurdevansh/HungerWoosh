package com.example.hungerwoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import com.example.hungerwoosh.databinding.ActivityLoginBinding
import com.example.hungerwoosh.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        databaseReference = Firebase.database.reference

        binding.btnLogin.setOnClickListener {
            checkInputs()
        }
        binding.tvDontHaveAccount.setOnClickListener {
            startActivity(Intent(this, SignActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null) {
            updateUi(currentUser)
        }
    }

    private fun checkInputs() {
        email = binding.etEmail.text.toString().trim()
        password = binding.etPassword.text.toString().trim()

        if(email.isNotBlank() && password.isNotBlank()) {
            loginUser()
        } else {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginUser() {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if(task.isSuccessful) {
                val user = auth.currentUser
                updateUi(user)
                Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        saveUserData()
                        val user = auth.currentUser
                        updateUi(user)
                        Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Signin Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun updateUi(user: FirebaseUser?) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun saveUserData() {
        val user = UserModel(email = email, password = password)
        val userId = auth.currentUser!!.uid
        databaseReference.child("user").child(userId).setValue(user)
    }
}