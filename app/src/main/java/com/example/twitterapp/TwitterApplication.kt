package com.example.twitterapp

import android.app.Application
import com.example.data.di.dataModule
import com.example.domain.di.interactionModule
import com.example.twitterapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TwitterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TwitterApplication)
            modules(
                presentationModule
                + interactionModule
                + dataModule
            )
        }
    }
}