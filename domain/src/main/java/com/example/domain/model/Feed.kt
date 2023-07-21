package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Feed(
    val blueTick: Boolean,
    val profilePic: String,
    val name: String,
    val userName: String,
    val comments: String,
    val date: String,
    val description: String,
    val likes: String,
    val retweets: String,
    val views: String
): Parcelable
