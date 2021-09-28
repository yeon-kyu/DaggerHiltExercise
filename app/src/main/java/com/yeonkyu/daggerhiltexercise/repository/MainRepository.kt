package com.yeonkyu.daggerhiltexercise.repository

import androidx.annotation.WorkerThread
import com.yeonkyu.daggerhiltexercise.model.TrackResponse
import com.yeonkyu.daggerhiltexercise.network.ITunesClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//class MainRepository @Inject constructor(
//    private val iTunesClient: ITunesClient
//): Repository {
//
//    suspend fun fetchTrackList(term:String, entity:String, limit:Int, offset:Int): TrackResponse =
//        withContext(Dispatchers.IO) {
//            iTunesClient.fetchTrackList(term, entity, limit, offset)
//        }
//}

interface MainRepository{

    suspend fun fetchTrackList(term:String, entity:String, limit:Int, offset:Int): TrackResponse
}