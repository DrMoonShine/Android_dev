package com.example.lab3

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toastBtn.setOnClickListener{
            val inflater = layoutInflater
            val container = findViewById<ViewGroup>(R.id.custom_toast_container)
            val layout: View = inflater.inflate(R.layout.custom_toast, container)
            val text: TextView = layout.findViewById(R.id.text)
            text.text = "Кастомное уведомление"
            with (Toast(applicationContext)) {
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
            createNotification()
        }

        binding.notificationBtn.setOnClickListener{
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            myDialogFragment.show(manager, "myDialog")
        }



    }
    @SuppressLint("UnspecifiedImmutableFlag")
    fun createNotification(){
        val intent = Intent(this@MainActivity, MainActivity::class.java)

        val pendingIntent = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
            PendingIntent.getActivity(this@MainActivity,0,intent, PendingIntent.FLAG_IMMUTABLE)
        else PendingIntent.getActivity(this@MainActivity,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val notification = NotificationCompat.Builder(this@MainActivity,"test_channel_id")
            .setSmallIcon(R.drawable.ic_baseline_error_outline_24)
            .setContentTitle("Уведомление в строке состояния")
            .setContentText("Уведомление в строке состояния")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        NotificationManagerCompat.from(this@MainActivity).notify(100,notification)
    }

}