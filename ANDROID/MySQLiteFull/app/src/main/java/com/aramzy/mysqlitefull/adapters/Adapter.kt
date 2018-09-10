package com.aramzy.mysqlitefull.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.aramzy.mysqlitefull.R
import com.aramzy.mysqlitefull.tables.Employee

class Adapter(private var mCTX: Context, var resource: Int, var items: List<Employee>): ArrayAdapter<Employee>(mCTX, resource, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCTX)
        val v: View = layoutInflater.inflate(resource, null)

        val employee: Employee = items[position]

        v.findViewById<TextView>(R.id.idLbl).text = employee.id
        v.findViewById<TextView>(R.id.fnameLbl).text = employee.first_name
        v.findViewById<TextView>(R.id.lnameLbl).text = employee.last_name

        return v
    }

}