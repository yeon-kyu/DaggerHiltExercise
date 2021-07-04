package com.yeonkyu.daggerhiltexercise


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yeonkyu.daggerhiltexercise.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchTrackList()
    }
}