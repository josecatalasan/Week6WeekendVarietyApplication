package com.example.week6weekendvarietyapplication.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.databinding.FragmentTimerButtonsBinding
import com.example.week6weekendvarietyapplication.viewmodel.TimerViewModel

class TimerButtonsFragment : Fragment() {

    lateinit var binder : FragmentTimerButtonsBinding
    lateinit var viewModel : TimerViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[TimerViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_timer_buttons,container, false)
        val view : View = binder.root
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = TimerButtonsFragment()
    }

}
