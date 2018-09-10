package com.aramzy.employeeapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.aramzy.employeeapp.dataClasses.Employee
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var firstName:   EditText
    private lateinit var lastName:    EditText
    private lateinit var address:     EditText
    private lateinit var department:  EditText

    private lateinit var saveBtn:     Button
    private lateinit var databaseBtn: Button

    private val dbName = "Employees"

    private val myAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setVariables()

        saveBtn.setOnClickListener {

            onSaveBtnClicked()

        }

        databaseBtn.setOnClickListener {

            onDatabaseBtnClicked()

        }

    }

    private fun setVariables() {

        firstName   = findViewById(R.id.editText)
        lastName    = findViewById(R.id.editText2)
        address     = findViewById(R.id.editText3)
        department  = findViewById(R.id.editText4)

        saveBtn     = findViewById(R.id.button)
        databaseBtn = findViewById(R.id.button2)

    }

    private fun onSaveBtnClicked() {

        saveData()

    }

    private fun onDatabaseBtnClicked() {

        val intent = Intent(this@MainActivity, EmployeeActivity::class.java)
        startActivity(intent)

    }

    private fun saveData() {

        val firstName: String  = this.firstName.text.toString().trim()
        val lastName: String   = this.lastName.text.toString().trim()
        val address: String    = this.address.text.toString().trim()
        val department: String = this.department.text.toString().trim()

        if(firstName.isEmpty()) {

            this.firstName.error = "Please enter your first name"
            return

        }

        if(lastName.isEmpty()) {

            this.lastName.error = "Please enter your first name"
            return

        }

        if(address.isEmpty()) {

            this.address.error = "Please enter your first name"
            return

        }

        if(department.isEmpty()) {

            this.department.error = "Please enter your first name"
            return

        }

        val myDatabase = FirebaseDatabase.getInstance().getReference(dbName)
        val employeeId = myDatabase.push().key
        val employee   = Employee(employeeId!!, firstName, lastName, address, department)
        myDatabase.child(employeeId).setValue(employee).addOnCompleteListener {

            task -> if(task.isSuccessful) {

            Toast.makeText(this, "Saved :)", Toast.LENGTH_SHORT).show()
            clearAll()

        } else {

            Toast.makeText(this, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()

        }

        }

    }

    private fun clearAll() {

        firstName.setText("")
        lastName.setText("")
        address.setText("")
        department.setText("")
        firstName.requestFocus()

    }

}