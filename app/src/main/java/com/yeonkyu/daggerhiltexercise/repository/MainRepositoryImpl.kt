package com.yeonkyu.daggerhiltexercise.repository

import com.yeonkyu.daggerhiltexercise.data.api.TrackListResponse
import com.yeonkyu.daggerhiltexercise.network.ITunesClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val iTunesClient: ITunesClient
) : MainRepository {

    override suspend fun fetchTrackList(
        term: String,
        entity: String,
        limit: Int,
        offset: Int
    ): TrackListResponse =
        withContext(Dispatchers.IO) {
            iTunesClient.fetchTrackList(term, entity, limit, offset)
        }
}