package com.example.week6weekendvarietyapplication.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.example.week6weekendvarietyapplication.R
import com.example.week6weekendvarietyapplication.databinding.FragmentTimerDisplayBinding
import com.example.week6weekendvarietyapplication.viewmodel.TimerViewModel


class TimerDisplayFragment : Fragment() {

    lateinit var binder : FragmentTimerDisplayBinding
    lateinit var viewModel : TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this)[TimerViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_timer_display,container, false)
        binder.viewModel = viewModel
        binder.lifecycleOwner = this
        return binder.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TimerDisplayFragment()
    }
}
