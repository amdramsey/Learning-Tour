package com.aramzy.employeeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.aramzy.employeeapp.adapter.Adapter
import com.aramzy.employeeapp.dataClasses.Employee
import com.google.firebase.database.*

class EmployeeActivity : AppCompatActivity() {

    private val dbName = "Employees"
    var db: DatabaseReference = FirebaseDatabase.getInstance().getReference(dbName)
    var dataList = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        getData()

    }

    private fun getData() {

        db.addValueEventListener(object: ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {

                if(p0 .exists()) {

                    dataList.clear()

                    for(e in p0.children) {

                        dataList.add(e.getValue(Employee::class.java)!!)

                    }

                }

                findViewById<ListView>(R.id.lv).adapter = Adapter(this@EmployeeActivity, dataList)

            }


        })

    }

}