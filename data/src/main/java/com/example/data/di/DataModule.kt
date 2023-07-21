package com.example.data.di

import com.example.data.networking.TwitterRetrofitClient
import com.example.data.repository.TwitterFeedRepositoryImpl
import com.example.domain.repository.FeedRepository
import org.koin.dsl.module

val dataModule = module {

    single { TwitterRetrofitClient() }

    single<FeedRepository> { TwitterFeedRepositoryImpl(get()) }
}