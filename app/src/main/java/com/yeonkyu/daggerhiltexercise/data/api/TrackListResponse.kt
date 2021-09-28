package com.yeonkyu.daggerhiltexercise.data.api

import com.google.gson.annotations.SerializedName

data class TrackListResponse(
    @SerializedName(value = "resultCount")
    val resultCount: Int,
    @SerializedName(value = "results")
    val results: ArrayList<TrackResponse>
)