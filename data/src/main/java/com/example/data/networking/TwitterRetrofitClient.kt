package com.example.data.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class TwitterRetrofitClient {

    companion object{
        private val BASE_URL = "https://run.mocky.io/"
    }

    fun getTwitterApiService(): TwitterApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getOkHttpClientBuilder().build())
        .build().create(TwitterApiService::class.java)

    private fun getOkHttpClientBuilder() = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
}