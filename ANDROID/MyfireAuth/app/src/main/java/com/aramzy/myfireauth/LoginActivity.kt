package com.aramzy.myfireauth

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    var myAuth = FirebaseAuth.getInstance()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.textView).text = ("${findViewById<TextView>(R.id.textView).text}\n${intent.getStringExtra("id")}")

        findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {

            Toast.makeText(this, "Logging out ...", Toast.LENGTH_SHORT).show()
            signOut()

            myAuth.addAuthStateListener {

                if(myAuth.currentUser == null) {

                    this.finish()

                }

            }


        })

    }

    override fun onDestroy() {

        super.onDestroy()

        myAuth.signOut()

    }

    private fun signOut() {

        myAuth.signOut()

    }

}