/*
 ********************************
 * Project name: Suq Althulatha *
 * Programmer: Ahmed Ramsey     *
 * Designer: Ahmed Ramsey       *
 ********************************
 */
package com.aramzy.suqaljumea

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import dataClasses.User
import lib.Toast

class LoginActivity : AppCompatActivity() {

    private val dbName   = "suqAljumeaUsers"
    private val mail     = "ramzy.a@yandex.com"
    private val pass     = "Ahmed2772003"
    private val auth     = FirebaseAuth.getInstance()
    private var dataList = arrayListOf<User>()

    private lateinit var db            : DatabaseReference
    private lateinit var mailTxt       : EditText
    private lateinit var passTxt       : EditText

    private lateinit var signBtn       : Button
    private lateinit var registerBtn   : Button

    private lateinit var userName      : String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setData()

        signBtn.setOnClickListener{
            if(!mailTxt.text.toString().trim().isEmpty()) {
                if(!passTxt.text.toString().trim().isEmpty()) {

                    login()

                } else {

                    passTxt.error = "Please enter your password"

                }
            }else{

                mailTxt.error = "Please enter the email"

            }
        }

        registerBtn.setOnClickListener{showRegistrationActivity()}

    }

    private fun setData() {

        mailTxt     = findViewById(R.id.mail)
        passTxt     = findViewById(R.id.pass)

        signBtn     = findViewById(R.id.button)
        registerBtn = findViewById(R.id.button2)

    }

    private fun login() {

        auth.signInWithEmailAndPassword(mail, pass)

        db = FirebaseDatabase.getInstance().getReference(dbName)

        db.addValueEventListener(object: ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {}

            override fun onDataChange(p0: DataSnapshot) {

                println("")

                if(p0.exists()) {

                    dataList.clear()

                    for(user in p0.children) {

                        val usr = user.getValue(User::class.java)!!
                        dataList.add(usr)

                    }

                }

                if(checkUAP()) {

                    showMainActivity(userName)

                } else {

                    Toast.makeText(this@LoginActivity, "Please check the username and the password")

                }

            }


        })

        auth.signOut()

    }

    private fun showRegistrationActivity() {

        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)

        startActivity(intent)

    }

    private fun checkUAP(): Boolean {

        for(user in dataList) {

            if(mailTxt.text.toString().trim() == user.mail) {

                if(passTxt.text.toString().trim() == user.pass) {

                    userName = user.name
                    return true

                }

            } else {

                continue

            }

        }

        return false

    }

    private fun showMainActivity(text: String) {

        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        intent.putExtra("name", text)

        startActivity(intent)

    }

}