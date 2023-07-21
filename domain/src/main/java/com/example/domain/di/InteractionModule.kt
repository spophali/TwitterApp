package com.example.domain.di

import com.example.domain.usecase.GetFeedDataUseCase
import org.koin.dsl.module

val interactionModule = module {

    factory { GetFeedDataUseCase(get()) }

}