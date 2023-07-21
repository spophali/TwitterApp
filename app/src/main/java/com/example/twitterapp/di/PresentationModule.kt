package com.example.twitterapp.di

import com.example.twitterapp.ui.dashboard.SearchViewModel
import com.example.twitterapp.ui.feed.FeedViewModel
import com.example.twitterapp.ui.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {

    //view models
    viewModel { FeedViewModel(get()) }
    viewModel { ProfileViewModel() }
    viewModel { SearchViewModel() }


}