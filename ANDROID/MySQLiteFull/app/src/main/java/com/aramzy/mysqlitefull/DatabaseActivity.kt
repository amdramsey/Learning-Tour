package com.aramzy.mysqlitefull

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.aramzy.mysqlitefull.adapters.Adapter
import android.widget.ListView
import android.widget.Toast
import com.aramzy.mysqlitefull.helper.DatabaseHelper
import com.aramzy.mysqlitefull.tables.Employee

class DatabaseActivity : AppCompatActivity() {

    var list = mutableListOf<Employee>()
    val helper: DatabaseHelper = DatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        viewAll()

        (findViewById<ListView>(R.id.lv)).adapter = Adapter(this, R.layout.employee, list)

    }

    private fun viewAll() {

        list.clear()
        val res = helper.alldata

        if(res.count == 0) {

            Toast.makeText(this, "No records", Toast.LENGTH_LONG).show()

        } else {

            while(res.moveToNext()) {

                list.add(Employee(res.getString(0), res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)))

            }

        }

    }

}