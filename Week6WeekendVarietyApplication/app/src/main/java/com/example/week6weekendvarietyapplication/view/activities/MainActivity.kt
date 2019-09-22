package com.example.week6weekendvarietyapplication.view.activities

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.view.dialogs.ImageDialogFragment
import com.example.week6weekendvarietyapplication.view.dialogs.OptionListDialog
import com.example.week6weekendvarietyapplication.view.dialogs.SmsDialog

class MainActivity : AppCompatActivity() {
    val optionsDialog = OptionListDialog(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun OnClickOptions(view: View) {
        optionsDialog.show()
    }
}
