package com.example.week6weekendvarietyapplication.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.view.fragments.TimerButtonsFragment
import com.example.week6weekendvarietyapplication.view.fragments.TimerDisplayFragment

class TimerActivity : AppCompatActivity() {
    lateinit var fragmentManager : FragmentManager
    lateinit var timerButtonsFragment: TimerButtonsFragment
    lateinit var timerDisplayFragment: TimerDisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        fragmentManager = supportFragmentManager

        timerButtonsFragment = TimerButtonsFragment.newInstance()
        timerDisplayFragment = TimerDisplayFragment.newInstance()

        fragmentManager.beginTransaction().replace(R.id.frameTimerButtons, timerButtonsFragment, "buttons").commit()
        fragmentManager.beginTransaction().replace(R.id.frameTimerCount, timerDisplayFragment, "display").commit()

    }
}
