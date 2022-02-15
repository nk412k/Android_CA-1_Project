package com.example.androidca_1project

import android.content.BroadcastReceiver
import android.content.Context

import android.content.Intent
import android.media.MediaPlayer


import android.util.Log
import android.widget.Toast



class AlarmManagerBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var mp = MediaPlayer.create(context, R.raw.alarm)
        Log.d("Started","Repeating alarm")
        mp.start()
        Toast.makeText(context, "Alarm Ringing", Toast.LENGTH_LONG).show()
    }
}