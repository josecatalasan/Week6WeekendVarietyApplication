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
import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.view.activities.PdfViewerActivity
import com.example.week6weekendvarietyapplication.view.activities.TimerActivity

class OptionListDialog(private val context : Context) : DialogInterface.OnClickListener {

    private val _pdfViewer = 0
    private val _dialogFragment = 1
    private val _sendSMS = 2
    private val _timer = 3
    private val _sendNotification = 4


    fun show() {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Choose a Feature")
            .setItems(R.array.dialog_choices, this).show()
    }

    override fun onClick(dialog : DialogInterface?, which: Int) {
        when (which) {
            _pdfViewer -> {
                val intent = Intent(context, PdfViewerActivity::class.java)
                context.startActivity(intent)
            }
            _dialogFragment -> {
                DoubleConfirmationDialog(context, false).show()
            }
            _sendSMS -> {
                val smsDialog = SmsDialog(context)
                smsDialog.show()
            }
            _timer -> {
                val intent = Intent(context, TimerActivity::class.java)
                context.startActivity(intent)
            }
            _sendNotification -> {
                buildNotification()
            }
        }
    }

    private fun buildNotification(){
        val intent = Intent(context, PdfViewerActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, System.currentTimeMillis().toInt(), intent, 0)

        val builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(context, "Channel")
        } else {
            Notification.Builder(context)
        }

        builder.setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Check out my Career Profile!")
            .setContentText("Click here to see it now!")
            .setContentIntent(pendingIntent)

        val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())
    }

}