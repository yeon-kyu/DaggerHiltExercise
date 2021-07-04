package com.yeonkyu.daggerhiltexercise.network

import com.yeonkyu.daggerhiltexercise.model.TrackResponse
import javax.inject.Inject

class ITunesClient @Inject constructor(
    private val ITunesSearchService: ITunesSearchService
): BaseClient() {
    suspend fun fetchTrackList(term:String, entity:String, limit:Int, offset:Int): TrackResponse =
        apiRequest { ITunesSearchService.fetchTrackList(term,entity,limit,offset) }
}