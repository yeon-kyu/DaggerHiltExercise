package com.yeonkyu.daggerhiltexercise.repository

import com.yeonkyu.daggerhiltexercise.data.api.TrackListResponse

interface MainRepository{

    suspend fun fetchTrackList(term:String, entity:String, limit:Int, offset:Int): TrackListResponse
}