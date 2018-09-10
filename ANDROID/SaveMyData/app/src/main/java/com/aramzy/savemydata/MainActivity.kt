package com.aramzy.savemydata

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity(private var sharedPreferences: SharedPreferences? = null) : AppCompatActivity() {

    private var lbl: TextView? = null
    private var txt: EditText? = null
    private val textKey: String? = "text_key"

    private val prefile: String = "com.aramzy.savemydata.preferences"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lbl = findViewById(R.id.lbl)
        txt = findViewById(R.id.txt)
        sharedPreferences = getSharedPreferences(prefile, Context.MODE_PRIVATE)

    }

    override fun onResume() {

        super.onResume()

        lbl!!.text = sharedPreferences!!.getString(textKey, "There is no value")

    }

    @SuppressLint("CommitPrefEdits")
    override fun onPause() {

        super.onPause()

        sharedPreferences!!.edit().putString(textKey, txt!!.text.toString()).apply()

    }

}