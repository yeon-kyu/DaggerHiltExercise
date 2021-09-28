package com.yeonkyu.daggerhiltexercise


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonkyu.daggerhiltexercise.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchTrackList()
    }
}