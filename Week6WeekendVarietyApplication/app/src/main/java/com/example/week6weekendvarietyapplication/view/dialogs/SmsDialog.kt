package com.example.week6weekendvarietyapplication.view.dialogs

import android.Manifest
import android.app.Activity
import android.content.Context
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.example.week6weekendvarietyapplication.R
import kotlinx.android.synthetic.main.dialog_send_sms.view.*
import java.lang.Exception


class SmsDialog(private val context : Context){

    fun show(){
        ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.SEND_SMS), 1)
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogView : View = inflater.inflate(R.layout.dialog_send_sms, null)
        dialogView.btnSendSms.setOnClickListener {
            try {
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(
                    dialogView.etPhoneNumber.text.toString(), null,
                    dialogView.etSmsMessage.text.toString(), null, null)
                Toast.makeText(context, "SMS Sent Successfully", Toast.LENGTH_SHORT).show()
            }catch (e : Exception){
                e.printStackTrace()
                Toast.makeText(context, "SMS Failed to Send, Try Again", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setView(dialogView).show()
    }

}