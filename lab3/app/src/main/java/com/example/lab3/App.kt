package com.example.lab3

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentValues
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) createNotificationChannel()

    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(){
        val name = "Test notification chanel"
        val descriptionText = "description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT

        val channel = NotificationChannel("test_channel_id",name,importance).apply {
            description = descriptionText
        }
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}