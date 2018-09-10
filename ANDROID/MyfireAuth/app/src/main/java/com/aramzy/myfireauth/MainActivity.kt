package com.aramzy.myfireauth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    var myAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {

            if(findViewById<EditText>(R.id.editText).text.toString() != "" && findViewById<EditText>(R.id.editText2).text.toString() != "") {

                signUp(findViewById<EditText>(R.id.editText).text.toString().trim(), findViewById<EditText>(R.id.editText2).text.toString().trim())

            } else {

                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()

            }

        })

        findViewById<Button>(R.id.button2).setOnClickListener(View.OnClickListener {

            view -> signIn(view, findViewById<EditText>(R.id.editText).text.toString().trim(), findViewById<EditText>(R.id.editText2).text.toString().trim())

            findViewById<EditText>(R.id.editText).setText("")
            findViewById<EditText>(R.id.editText2).setText("")
            findViewById<EditText>(R.id.editText).requestFocus()

        })

    }

    private fun signUp(mail: String, pass: String) {

        myAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, OnCompleteListener {

            task -> if(task.isSuccessful) {Toast.makeText(this, "Done successfully", Toast.LENGTH_SHORT).show()} else {Toast.makeText(this, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()}

        })

        findViewById<EditText>(R.id.editText).setText("")
        findViewById<EditText>(R.id.editText2).setText("")
        findViewById<EditText>(R.id.editText).requestFocus()

    }

    private fun signIn(view: View, mail: String, pass: String) {

        Toast.makeText(this, "Authenticating ... ", Toast.LENGTH_SHORT).show()

        myAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(this, OnCompleteListener {

            task -> if(task.isSuccessful) {

            val intent: Intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("id", myAuth.currentUser!!.email)
            startActivity(intent)

        } else {

            Toast.makeText(this, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()

        }

        })

    }

}