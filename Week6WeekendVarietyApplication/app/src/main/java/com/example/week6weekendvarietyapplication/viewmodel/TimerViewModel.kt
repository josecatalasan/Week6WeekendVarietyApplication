package com.example.week6weekendvarietyapplication.viewmodel

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import java.util.*

class TimerViewModel : ViewModel() {

    private var timer : Timer
    val timerCount = MutableLiveData<String>()
    var secondCounter = 0.0
    var minuteCounter = 0

    init{
        timer = Timer()
        timerCount.value = ""+secondCounter+"s"
    }

    fun onStartClicked(){
        timer.cancel()
        timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                secondCounter += 0.1
                if(secondCounter >= 60.0) {
                    minuteCounter++
                    secondCounter -= 60.0
                }
                secondCounter = "%.2f".format(secondCounter).toDouble()

                if(minuteCounter > 0)
                    timerCount.postValue("" +minuteCounter+"m "+ secondCounter + "s")
                else
                    timerCount.postValue(""+secondCounter +"s")
            }
        }, 0,100)
    }

    fun onStopClicked() {
        if(secondCounter > 0.0) {
            timer.cancel()
        }
    }

    fun onResetClicked(){
        timer.cancel()
        secondCounter = 0.0
        minuteCounter = 0
        timerCount.value = ""+secondCounter+"s"
    }
}