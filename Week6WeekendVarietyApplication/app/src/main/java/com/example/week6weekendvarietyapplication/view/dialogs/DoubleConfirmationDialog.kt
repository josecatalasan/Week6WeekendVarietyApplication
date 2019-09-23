package com.example.week6weekendvarietyapplication.view.dialogs

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.example.week6weekendvarietyapplication.view.activities.MainActivity
import com.example.week6weekendvarietyapplication.view.fragments.ImageDialogFragment

class DoubleConfirmationDialog(private val context : Context, private val youSure : Boolean) : DialogInterface.OnClickListener{

    fun show(){
        val builder = AlertDialog.Builder(context)

        if(youSure){
            builder.setTitle("Are you SURE you want to do this?")
            builder.setMessage("You have to be sure.")
        } else {
            builder.setTitle("Do you want to do this?")
        }

        builder.setPositiveButton("Yes", this)
            .setNegativeButton("No", this)
            .show()

    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        when(which){
            DialogInterface.BUTTON_POSITIVE ->{
                if(youSure){
                    ImageDialogFragment()
                        .show((context as MainActivity).getDialogManager(), "ImageDialogFragment")
                } else {
                    DoubleConfirmationDialog(context, true).show()
                }
            }
            DialogInterface.BUTTON_NEGATIVE ->{}
        }
    }
}