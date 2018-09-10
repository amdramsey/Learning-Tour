package com.aramzy.learning

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener(View.OnClickListener {

            val intent = Intent()
            val pendingIntent = PendingIntent.getActivity(this@MainActivity,0,intent,0)
            val notification = Notification.Builder(this@MainActivity)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Muhammed Essa")
                    .setContentText("Hello Body")
            notification.setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


            notificationManager.notify(0,notification.build())

        })

    }

}