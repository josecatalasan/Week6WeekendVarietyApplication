package com.example.week6weekendvarietyapplication.view.activities

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.view.dialogs.OptionListDialog
class MainActivity : AppCompatActivity() {
    val optionsDialog = OptionListDialog(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =  NotificationChannel("Channel", "Channel name", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
    }

    fun OnClickOptions(view: View) {
        optionsDialog.show()
    }
}
