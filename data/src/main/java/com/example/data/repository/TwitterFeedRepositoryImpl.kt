package com.example.data.repository

import com.example.data.networking.TwitterRetrofitClient
import com.example.domain.model.Feed
import com.example.domain.repository.FeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TwitterFeedRepositoryImpl(
    private val twitterRetrofitClient: TwitterRetrofitClient
) : FeedRepository {
    override suspend fun getFeedData(): List<Feed> = withContext(Dispatchers.IO) {
        val feedData = twitterRetrofitClient.getTwitterApiService().getFeedData()
        val feedList = arrayListOf<Feed>()
        feedData.forEach {
            feedList.add(it.toFeed())
        }
        feedList
    }
}