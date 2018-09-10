package com.aramzy.mysqlitefull.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    val alldata: Cursor
        get() {

            val db = this.writableDatabase
            return db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        }

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("CREATE TABLE $TABLE_NAME($COL_1 INTEGER PRIMARY KEY AUTOINCREMENT, $COL_2 TEXT, $COL_3 TEXT, $COL_4 INTEGER, $COL_5 TEXT, $COL_6 TEXT)")

    }

    fun insertData(first_name: String, last_name: String, age: String, address: String, department: String) {

        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_2, first_name)
        contentValues.put(COL_3, last_name)
        contentValues.put(COL_4, age)
        contentValues.put(COL_5, address)
        contentValues.put(COL_6, department)

        db.insert(TABLE_NAME, null, contentValues)

    }

    fun updateData(id: String, first_name: String, last_name: String, age: String, address: String, department: String): Int {

        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_1, id)
        contentValues.put(COL_2, first_name)
        contentValues.put(COL_3, last_name)
        contentValues.put(COL_4, age)
        contentValues.put(COL_5, address)
        contentValues.put(COL_6, department)

        return db.update(TABLE_NAME, contentValues, "$COL_1 = ?", arrayOf(id))

    }

    fun deleteData(id: String): Int {

        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$COL_1 =  ?", arrayOf(id))

    }

    companion object {

        // Immutable variables
        const val DATABASE_NAME: String = "EMPLOYEE.db"
        const val TABLE_NAME: String = "EMPLOYEE_table"
        const val COL_1: String = "ID"
        const val COL_2: String = "first_name"
        const val COL_3: String = "last_name"
        const val COL_4: String = "age"
        const val COL_5: String = "address"
        const val COL_6: String = "department"

    }

}