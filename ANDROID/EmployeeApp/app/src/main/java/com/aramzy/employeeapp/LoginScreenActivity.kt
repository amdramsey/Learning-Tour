package com.aramzy.employeeapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginScreenActivity : AppCompatActivity() {

    private val myAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        findViewById<Button>(R.id.button).setOnClickListener {

            signIn(findViewById<EditText>(R.id.editText).text.toString().trim(), findViewById<EditText>(R.id.editText2).text.toString().trim())

        }

    }

    private fun signIn(mail: String, pass: String) {

        myAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener{

            task -> if(task.isSuccessful) {

            Toast.makeText(this, "Signed in successfully", Toast.LENGTH_SHORT).show()
            clearAll()
            startMainActivity()

        } else {

            Toast.makeText(this, "${task.exception!!.message}", Toast.LENGTH_LONG).show()

        }

        }

    }

    private fun startMainActivity() {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

    private fun clearAll() {

        findViewById<EditText>(R.id.editText).setText("")
        findViewById<EditText>(R.id.editText2).setText("")
        findViewById<EditText>(R.id.editText).requestFocus()

    }

    override fun onDestroy() {

        super.onDestroy()

        myAuth.signOut()

    }

}