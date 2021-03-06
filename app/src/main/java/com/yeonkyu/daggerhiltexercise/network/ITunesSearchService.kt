package com.yeonkyu.daggerhiltexercise.network

import com.yeonkyu.daggerhiltexercise.data.api.TrackListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesSearchService {

    @GET("/search?")
    suspend fun fetchTrackList(
        @Query("term") term:String,
        @Query("entity") entity:String,
        @Query("limit") limit: Int,
        @Query("offset") offset:Int
    ) : Response<TrackListResponse>
}