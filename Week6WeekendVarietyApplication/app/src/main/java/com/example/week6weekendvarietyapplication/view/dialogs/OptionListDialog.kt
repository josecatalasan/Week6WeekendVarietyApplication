package com.example.week6weekendvarietyapplication.view.dialogs

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.view.activities.MainActivity
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
                    PDF_VIEWER -> {}
                    DIALOG_FRAGMENT -> {
                        ImageDialogFragment().show((context as MainActivity).supportFragmentManager, "ImageDialogFragment")
                    }
                    SEND_SMS -> {
                        val smsDialog = SmsDialog(context)
                        smsDialog.show()
                    }
                    STOPWATCH -> {
                        var intent = Intent(context, TimerActivity::class.java)
                        context.startActivity(intent)
                    }
                }
        }).show()

    }

}