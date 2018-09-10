package com.aramzy.adduser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val myAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.register).setOnClickListener{

            signUp(findViewById<EditText>(R.id.email).text.toString().trim(), findViewById<EditText>(R.id.pass).text.toString().trim())

        }

    }

    private fun signUp(mail: String, pass: String) {


        myAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener{

            task -> if(task.isSuccessful) {

            findViewById<EditText>(R.id.email).setText("")
            findViewById<EditText>(R.id.pass).setText("")
            findViewById<EditText>(R.id.email).requestFocus()

            Toast.makeText(this, "Done :)", Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(this, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()

        }

        }

    }

}