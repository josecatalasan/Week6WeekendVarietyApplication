package com.example.week6weekendvarietyapplication.viewmodel

import android.text.Editable
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import java.util.*

class TimerViewModel : ViewModel() {

    private var timer : Timer
    val timerCount = MutableLiveData<String>()
    val duration = MutableLiveData<Double>()
    var counter = 0.0

    init{
        timer = Timer()
        duration.value = 5.0
        timerCount.value = "Enter Timer Duration"
    }

    fun durationChange(editable : Editable){
        if(editable.toString() != "")
            duration.postValue(editable.toString().toDouble())
    }

    fun reset(){
        counter = 0.0
        timer.cancel()
    }

    fun onStartClicked(){
        reset()
        timer = Timer()
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                counter += 0.1
                counter ="%.2f".format(counter).toDouble()
                timerCount.postValue("In progress: $counter")
                if(counter >= duration.value!!){
                    reset()
                    timerCount.postValue("Completed")
                }
            }
        }, 0,100)
    }

    fun onStopClicked() {
        if(counter > 0.0) {
            reset()
            timerCount.value = "Stopped"
        }
    }
}