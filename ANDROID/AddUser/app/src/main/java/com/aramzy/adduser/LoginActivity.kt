package com.aramzy.adduser

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private var myAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.sign_in).setOnClickListener{

            signIn(findViewById<EditText>(R.id.email).text.toString().trim(), findViewById<EditText>(R.id.pass).text.toString().trim())

        }

    }

    private fun signIn(mail: String, pass: String) {

        myAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener{

            task -> if(task.isSuccessful) {

            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()

            findViewById<EditText>(R.id.email).setText("")
            findViewById<EditText>(R.id.pass).setText("")
            findViewById<EditText>(R.id.email).requestFocus()

            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)

        } else {

            Toast.makeText(this, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()

        }

        }

    }

    override fun onPause() {

        super.onPause()

        myAuth.signOut()

    }

}