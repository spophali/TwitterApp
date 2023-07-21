package com.example.domain.usecase

import com.example.domain.model.Feed
import com.example.domain.repository.FeedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetFeedDataUseCase(
    private val feedRepository: FeedRepository
) {
    suspend operator fun invoke(): List<Feed> = withContext(Dispatchers.IO) {
        feedRepository.getFeedData()
    }
}