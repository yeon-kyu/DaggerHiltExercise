package com.yeonkyu.daggerhiltexercise.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yeonkyu.daggerhiltexercise.R
import com.yeonkyu.daggerhiltexercise.databinding.ActivityMainBinding
import com.yeonkyu.daggerhiltexercise.viewModel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var trackAdapter: TrackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val linearLayoutManager = LinearLayoutManager(this)
        binding.trackListRecyclerview.layoutManager = linearLayoutManager

        trackAdapter = TrackAdapter()
        binding.trackListRecyclerview.adapter = trackAdapter

        setUpViewModel()

        viewModel.fetchTrackList()
    }

    private fun setUpViewModel(){
        viewModel.resetTrackList()

        viewModel.trackList.observe(binding.lifecycleOwner!!,{
            Log.e("CHECK_TAG","track list change observed")
            trackAdapter.setTrackList(it)
        })
    }
}