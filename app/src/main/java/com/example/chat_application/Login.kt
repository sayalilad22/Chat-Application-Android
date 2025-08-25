package com.example.chat_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var edt_email: EditText
    private lateinit var edt_password:EditText
    private lateinit var btn_login:Button
    private lateinit var btn_signup:Button
    private lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        mAuth=FirebaseAuth.getInstance()
        edt_email = findViewById(R.id.edt_email)
        edt_password = findViewById(R.id.edt_password)
        btn_login = findViewById(R.id.btn_login)
        btn_signup = findViewById(R.id.btn_signup)

        btn_signup.setOnClickListener {

            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener{

            val email=edt_email.text.toString()
            val password=edt_password.text.toString()

            login(email,password)
        }

    }
    private fun login(email: String, password: String) {
        // Optional: Show progress bar here

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful
                    val intent = Intent(this@Login, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                    // Prevent going back to login
                } else {
                    // Login failed
                    Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
                }

                // Optional: Hide progress bar here
            }
    }
}