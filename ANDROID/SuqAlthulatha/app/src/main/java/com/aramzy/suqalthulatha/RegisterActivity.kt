/*
 ********************************
 * Project name: Suq Althulatha *
 * Programmer: Ahmed Ramsey     *
 * Designer: Ahmed Ramsey       *
 ********************************
 */
package com.aramzy.suqalthulatha

import LIB.Toast
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dataClasses.User

class RegisterActivity : AppCompatActivity() {

    private val dbName  = "suqAljumeaUsers"
    private val mail    = "ramzy.a@yandex.com"
    private val pass    = "Ahmed2772003"
    private val auth    = FirebaseAuth.getInstance()

    private lateinit var db         : DatabaseReference
    private lateinit var mailTxt    : EditText
    private lateinit var passTxt    : EditText
    private lateinit var nameTxt    : EditText
    private lateinit var cpassTxt   : EditText

    private lateinit var registerBtn: Button
    private lateinit var clearBtn   : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setData()

        registerBtn.setOnClickListener{

            if(!mailTxt.text.toString().trim().isEmpty()) {
                if(!passTxt.text.toString().trim().isEmpty()) {

                    if(passTxt.text.toString().trim() == cpassTxt.text.toString().trim()) {register();clearAll()}else{Toast.makeText(this, "Password doesn't not match")}

                }
            }else{

                mailTxt.error = "Please enter the email"
                passTxt.error = "Please enter your password"

            }

        }

        clearBtn.setOnClickListener{clearAll()}

    }

    private fun setData() {

        mailTxt     = findViewById(R.id.mail)
        nameTxt     = findViewById(R.id.name)
        passTxt     = findViewById(R.id.pass)
        cpassTxt    = findViewById(R.id.repass)

        registerBtn = findViewById(R.id.button)
        clearBtn    = findViewById(R.id.button2)

    }

    private fun register() {

        auth.signInWithEmailAndPassword(mail, pass)

        db = FirebaseDatabase.getInstance().getReference(dbName)

        val userID = db.push().key!!

        val user = User(userID, mailTxt.text.toString().trim(), nameTxt.text.toString().trim(), passTxt.text.toString().trim())

        db.child(userID).setValue(user).addOnCompleteListener{

            task -> if(task.isSuccessful) {

            LIB.Toast.makeText(this, "Saved :)")

        } else {

            Toast.makeText(this, "Error: ${task.exception!!.message}")

        }

        }

        auth.signOut()

    }

    private fun clearAll() {

        mailTxt.setText("")
        passTxt.setText("")
        nameTxt.setText("")
        cpassTxt.setText("")
        mailTxt.requestFocus()

    }

}