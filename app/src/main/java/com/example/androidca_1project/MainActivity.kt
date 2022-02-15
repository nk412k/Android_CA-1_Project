package com.example.androidca_1project

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.getSystemService

class MainActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ratebtn = findViewById<ImageButton>(R.id.ratebtn)
        ratebtn.setOnClickListener {
                    val i = Intent(this, RatingPage::class.java)
                    startActivity(i)
            }
        val timePicker = findViewById<TimePicker>(R.id.simpleTimePicker)
        val start = findViewById<Button>(R.id.start)
        val rstart = findViewById<Button>(R.id.rstart)
        val stop = findViewById<Button>(R.id.stop)
        var alarmManager:AlarmManager
        val intent = Intent(this,AlarmManagerBroadcast::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,0, intent, 0)

        val calendar: Calendar = Calendar.getInstance()
        calendar.set(
            timePicker.hour,
            timePicker.minute,
            0
        )

        start.setOnClickListener {
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pendingIntent)
            Toast.makeText(this, "Alarm set", Toast.LENGTH_LONG ).show()
        }

        rstart.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,60000,pendingIntent)
            Toast.makeText(this,"Repeating Alarm in 1 minute", Toast.LENGTH_LONG).show()
        }

        stop.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this,"Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

}

