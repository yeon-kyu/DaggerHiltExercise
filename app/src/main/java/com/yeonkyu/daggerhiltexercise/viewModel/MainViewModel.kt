package com.yeonkyu.daggerhiltexercise.viewModel

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yeonkyu.daggerhiltexercise.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.yeonkyu.daggerhiltexercise.data.api.TrackResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
): ViewModel(){

    private val pagingLimit : Int = 20
    private var pagingOffset : Int = 0

    private val trackList = ArrayList<TrackResponse>()
    val liveTrackList: MutableLiveData<ArrayList<TrackResponse>> by lazy{
        MutableLiveData<ArrayList<TrackResponse>>()
    }

    val isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }
    }

    init {
        Log.e("TAG","MainViewModel injected")
    }

    fun resetTrackList(){
        pagingOffset = 0
        trackList.clear()
    }

    fun fetchTrackList() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = repository.fetchTrackList(
                    term = "greenday",
                    entity = "song",
                    limit = pagingLimit,
                    offset = pagingOffset
                )

                for (track in response.results) {
                    val isFavorite = false
                    track.isFavorite = isFavorite
                    trackList.add(track)
                }
                liveTrackList.postValue(trackList)
                pagingOffset += pagingLimit
            }
            catch (e: Exception){
                Log.e("ERROR_TAG", "searchTrack error : $e")
            }
            finally {
                isLoading.postValue(false)
            }
        }
    }

}