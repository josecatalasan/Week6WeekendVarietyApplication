package com.example.week6weekendvarietyapplication.view.dialogs

import android.content.Context
import androidx.appcompat.app.AlertDialog

class DefaultDialog(private val context : Context, private val youSure : Boolean){

    fun show(){
        val builder = AlertDialog.Builder(context)

        if(youSure){
            builder.setTitle("Are you SURE you want to do this?")
        } else {
            builder.setTitle("Do you want to do this?")
        }

    }
}