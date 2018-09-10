package com.aramzy.learning

import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var id = 1
    lateinit var manager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.add).setOnClickListener{

            val builder = NotificationCompat.Builder(this).setContentTitle("Title").setContentText("This a test from ahmed ramsey").setSmallIcon(R.drawable.ic_notification_icon)

            manager  = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.notify(id, builder.build())

            id += 1

        }

        findViewById<Button>(R.id.delete).setOnClickListener{

            //

        }

    }

}