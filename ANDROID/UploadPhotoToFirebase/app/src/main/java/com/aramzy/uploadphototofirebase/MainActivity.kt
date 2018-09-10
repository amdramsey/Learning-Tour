package com.aramzy.uploadphototofirebase

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var button2: Button

    private lateinit var img    : ImageView

    private lateinit var storage: StorageReference

    private lateinit var pd: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button  = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)

        img     = findViewById(R.id.img)

        storage = FirebaseStorage.getInstance().reference

        button.setOnClickListener{

            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 2)

        }

        button2.setOnClickListener{

            //

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 2 && resultCode == Activity.RESULT_OK) {

            pd = ProgressDialog(this@MainActivity)
            pd.setMessage("Upload ...")
            pd.show()

            val uri: Uri = data!!.data

            val img = storage.child("Photos").child(uri.lastPathSegment)
            img.putFile(uri).addOnSuccessListener{

                Toast.makeText(this@MainActivity, "Done :)", Toast.LENGTH_SHORT).show()

                pd.dismiss()

            }

        }

    }

}