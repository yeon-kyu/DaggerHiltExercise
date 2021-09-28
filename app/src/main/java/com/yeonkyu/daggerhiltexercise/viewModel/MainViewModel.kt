package com.yeonkyu.daggerhiltexercise.viewModel

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yeonkyu.daggerhiltexercise.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel(){

    fun fetchTrackList() {
        viewModelScope.launch {
            val response = repository.fetchTrackList("greenday","song",20,0)
            Log.e("DH_CHECK","response : $response")
        }

    }

}