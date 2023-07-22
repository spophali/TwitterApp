package com.example.data.networking

import com.example.data.model.FeedData
import retrofit2.http.GET

interface TwitterApiService {

    @GET("v3/604c197b-8c2f-4286-82b1-554090174bd5")
    suspend fun getFeedData(): List<FeedData>
}