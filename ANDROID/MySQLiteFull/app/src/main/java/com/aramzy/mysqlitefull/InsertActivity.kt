package com.aramzy.mysqlitefull

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.aramzy.mysqlitefull.helper.DatabaseHelper

class InsertActivity : AppCompatActivity() {

    internal val helper: DatabaseHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        (findViewById<Button>(R.id.insertBtn)).setOnClickListener(View.OnClickListener {

            helper.insertData(

                    department = findViewById<EditText>(R.id.departmentTxt).text.toString(),
                    address    = findViewById<EditText>(R.id.addressTxt).text.toString(),
                    first_name = findViewById<EditText>(R.id.fnameTxt).text.toString(),
                    last_name  = findViewById<EditText>(R.id.lnameTxt).text.toString(),
                    age        = findViewById<EditText>(R.id.ageTxt).text.toString()

            )

            findViewById<EditText>(R.id.departmentTxt).setText("")
            findViewById<EditText>(R.id.addressTxt).setText("")
            findViewById<EditText>(R.id.fnameTxt).setText("")
            findViewById<EditText>(R.id.lnameTxt).setText("")
            findViewById<EditText>(R.id.ageTxt).setText("")

            findViewById<EditText>(R.id.fnameTxt).requestFocus()

            Toast.makeText(this, "Inserted", Toast.LENGTH_LONG).show()

        })

    }

}