package com.example.data.model

import com.example.domain.model.Feed

data class FeedData(
    val post: Post,
    val profile: Profile
) {
    fun toFeed() = Feed(
        profile.bluetick,
        profile.img,
        profile.name,
        profile.username,
        post.comments,
        post.date,
        post.description,
        post.likes,
        post.retweets,
        post.views
    )
}