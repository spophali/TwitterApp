package com.example.data.networking

import com.example.data.model.FeedData
import retrofit2.http.GET

interface TwitterApiService {

    @GET("v3/5585d3b7-e49c-485b-99a4-ec2823db0d3c")
    suspend fun getFeedData(): List<FeedData>
}