package com.example.week6weekendvarietyapplication.view.dialogs

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AlertDialog
import androidx.core.content.getSystemService
import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.view.activities.MainActivity
import com.example.week6weekendvarietyapplication.view.activities.PdfViewerActivity
import com.example.week6weekendvarietyapplication.view.activities.TimerActivity

class OptionListDialog(private val context : Context) {
    val PDF_VIEWER = 0
    val DIALOG_FRAGMENT = 1
    val SEND_SMS = 2
    val STOPWATCH = 3
    val SEND_NOTIFICATION = 4


    fun show() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Choose a Feature")
            .setItems(R.array.dialog_choices, DialogInterface.OnClickListener {
            dialog,id ->
                when(id){
                    PDF_VIEWER -> {
                        val intent = Intent(context, PdfViewerActivity::class.java)
                        context.startActivity(intent)
                    }
                    DIALOG_FRAGMENT -> {
                        ImageDialogFragment().show((context as MainActivity).supportFragmentManager, "ImageDialogFragment")
                    }
                    SEND_SMS -> {
                        val smsDialog = SmsDialog(context)
                        smsDialog.show()
                    }
                    STOPWATCH -> {
                        val intent = Intent(context, TimerActivity::class.java)
                        context.startActivity(intent)
                    }
                    SEND_NOTIFICATION -> {
                        val intent = Intent(context, PdfViewerActivity::class.java)
                        val pendingIntent = PendingIntent.getActivity(context, System.currentTimeMillis().toInt(), intent, 0)
                        val notification = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            Notification.Builder(context, "Channel")
                                .setSmallIcon(R.drawable.ic_notification)
                                .setContentTitle("IS THIS WORKING?!")
                                .setContentText("HELLLOOOOO?!?!")
                                .setContentIntent(pendingIntent).build()
                        } else {
                            TODO("VERSION.SDK_INT < O")
//                            Notification.Builder(context)
//                                .setSmallIcon(R.drawable.ic_notification)
//                                .setContentTitle("IS THIS WORKING?!")
//                                .setContentText("HELLLOOOOO?!?!")
//                                .setContentIntent(pendingIntent).build()
                        }
                        val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                        manager.notify(0, notification)
                    }
                }
        }).show()

    }

}