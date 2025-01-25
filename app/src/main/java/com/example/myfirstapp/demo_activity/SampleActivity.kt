package com.example.myfirstapp.demo_activity

import android.app.NotificationManager
import android.app.NotificationChannel
import android.app.Notification
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.R
import android.Manifest
import androidx.core.app.ActivityCompat

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sample)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1000
        )
        notify("From onCreate method")

    }

    override fun onStart() {
        super.onStart()
        notify("From onStart method")
    }

    override fun onResume() {
        super.onResume()
        notify("From onResume method")
    }

    override fun onPause() {
        super.onPause()
        notify("From onPause method")
    }

    override fun onStop() {
        super.onStop()
        notify("From onStop method")
    }

    override fun onDestroy() {
        super.onDestroy()
        notify("From onDestroy method")
    }

    override fun onRestart() {
        super.onRestart()
        notify("From onRestart method")
    }

    fun notify(methodName: String) {
        val name = this.javaClass.name
        val strings = name.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()

        val channelId = "default_channel_id"
        val channelName = "Default Channel"
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // For devices running API 26+
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Default channel for notifications"
            }
            notificationManager.createNotificationChannel(channel)
        }

        // Create the notification builder
        val notificationBuilder =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                Notification.Builder(this, channelId) // Use channelId for API 26+
            } else {
                Notification.Builder(this) // No channelId for API < 26
                    .setPriority(Notification.PRIORITY_DEFAULT) // Set priority for pre-Oreo
            }

        notificationBuilder
            .setContentTitle("$methodName  ${strings.last()}")
            .setContentText(name)
            .setSmallIcon(com.example.myfirstapp.R.mipmap.ic_launcher)
            .setAutoCancel(true)

        // Display the notification
        notificationManager.notify(System.currentTimeMillis().toInt(), notificationBuilder.build())
    }
}