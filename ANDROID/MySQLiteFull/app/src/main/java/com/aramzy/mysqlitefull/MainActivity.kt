package com.aramzy.mysqlitefull

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var databaseBtn: Button
    lateinit var insertBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseBtn = findViewById(R.id.databaseBtn)
        insertBtn   = findViewById(R.id.insertDB)

        databaseBtn.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this, DatabaseActivity::class.java)
            startActivity(intent)

        })

        insertBtn.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this, InsertActivity::class.java)
            startActivity(intent)

        })

    }

}