package com.aramzy.firebasrealtimelearning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.aramzy.firebasrealtimelearning.dataClasses.Employee
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var firstName:   EditText
    lateinit var lastName:    EditText
    lateinit var address:     EditText
    lateinit var department:  EditText

    lateinit var saveBtn:     Button
    lateinit var databaseBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setVariables()

        saveBtn.setOnClickListener(View.OnClickListener {

            onSaveBtnClicked()

        })

        databaseBtn.setOnClickListener(View.OnClickListener {

            onDatabaseBtnClicked()

        })

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

        val intent: Intent = Intent(this@MainActivity, EmployeesActivity::class.java)
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

        val myDatabase = FirebaseDatabase.getInstance().getReference("Employees")
        val id = myDatabase.push().key
        val employee: Employee = Employee(id!!, firstName, lastName, address, department)
        myDatabase.child(id).setValue(employee).addOnCompleteListener {

            Toast.makeText(this, "Saved :)", Toast.LENGTH_LONG).show()

        }

    }

}