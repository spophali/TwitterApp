package com.example.domain.repository

import com.example.domain.model.Feed

interface FeedRepository {

    suspend fun getFeedData(): List<Feed>
}