package com.example.week6weekendvarietyapplication.view.dialogs

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.week6weekendvarietyapplication.R

class ImageDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    = inflater.inflate(R.layout.dialog_three_second_image,container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Handler().postDelayed({dismiss()},3000)
    }

}