package com.aramzy.employeeapp.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.aramzy.employeeapp.R
import com.aramzy.employeeapp.dataClasses.Employee
import com.google.firebase.database.FirebaseDatabase

class Adapter(private var context: Context, private var dataList: ArrayList<Employee>) : BaseAdapter() {

    private val dbName = "Employees"

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = inflater.inflate(R.layout.employees, parent, false)

        v.findViewById<TextView>(R.id.textView ).text = dataList[position].firstName
        v.findViewById<TextView>(R.id.textView2).text = dataList[position].lastName
        v.findViewById<TextView>(R.id.textView3).text = dataList[position].address
        v.findViewById<TextView>(R.id.textView4).text = dataList[position].department

        v.findViewById<Button>(R.id.button).setOnClickListener{

            update(dataList.get(position))

        }

        v.findViewById<Button>(R.id.button2).setOnClickListener{

            delete(dataList.get(position))

        }

        return v

    }

    override fun getItem(position: Int): Any {

        return dataList[position]

    }

    override fun getItemId(position: Int): Long {

        return 0

    }

    override fun getCount(): Int {

        return dataList.size

    }

    private fun delete(employee: Employee) {

        val db = FirebaseDatabase.getInstance().getReference(dbName)
        db.child(employee.id).removeValue().addOnCompleteListener{

            task -> if(task.isSuccessful) {

            Toast.makeText(context, "Deleted1", Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(context, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()

        }

        }

    }

    private fun update(employee: Employee) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Update ${employee.firstName} information")
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(R.layout.employee_update, null, false)

        v.findViewById<EditText>(R.id.editText).setText(employee.firstName)
        v.findViewById<EditText>(R.id.editText2).setText(employee.lastName)
        v.findViewById<EditText>(R.id.editText3).setText(employee.address)
        v.findViewById<EditText>(R.id.editText4).setText(employee.department)

        builder.setView(v)
        builder.setPositiveButton("Update", object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {

                val db = FirebaseDatabase.getInstance().getReference(dbName)
                val firstName: String   = v.findViewById<EditText>(R.id.editText ).text.toString().trim()
                val lastName: String    = v.findViewById<EditText>(R.id.editText2).text.toString().trim()
                val address: String     = v.findViewById<EditText>(R.id.editText3).text.toString().trim()
                val department: String  = v.findViewById<EditText>(R.id.editText4).text.toString().trim()

                if(firstName.isEmpty()) {

                    v.findViewById<EditText>(R.id.editText).error = "Please enter your first name"
                    return

                }

                if(lastName.isEmpty()) {

                    v.findViewById<EditText>(R.id.editText2).error = "Please enter your first name"
                    return

                }

                if(address.isEmpty()) {

                    v.findViewById<EditText>(R.id.editText3).error = "Please enter your first name"
                    return

                }

                if(department.isEmpty()) {

                    v.findViewById<EditText>(R.id.editText4).error = "Please enter your first name"
                    return

                }

                val myDatabase = FirebaseDatabase.getInstance().getReference(dbName)
                val employee = Employee(employee.id, firstName, lastName, address, department)
                myDatabase.child(employee.id).setValue(employee).addOnCompleteListener {

                    task -> if(task.isSuccessful) {

                    Toast.makeText(context, "Updated :)", Toast.LENGTH_SHORT).show()

                } else {

                    Toast.makeText(context, "${task.exception!!.message}", Toast.LENGTH_SHORT).show()

                }

                }

            }


        })

        builder.setNegativeButton("Cancel", object:DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {

                builder.setCancelable(true)

            }


        })

        val alert = builder.create()
        alert.show()

    }

}