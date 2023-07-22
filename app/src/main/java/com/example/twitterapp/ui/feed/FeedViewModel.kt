package com.example.twitterapp.ui.feed

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Feed
import com.example.domain.usecase.GetFeedDataUseCase
import com.example.twitterapp.SingleLiveEvent
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@OptIn(KoinApiExtension::class)
class FeedViewModel(
    private val getFeedDataUseCase: GetFeedDataUseCase
) : ViewModel(), KoinComponent {

    private val _feedLiveData = SingleLiveEvent<List<Feed>>()

    val feedLiveData = _feedLiveData

    private val _errorLiveData = SingleLiveEvent<String>()

    val errorLiveData = _errorLiveData

    private val _loadingLiveData = SingleLiveEvent<Boolean>()

    val loadingLiveData = _loadingLiveData

    fun getFeedData() {
        viewModelScope.launch {
            try {
                onLoading(true)
                val feedDataList = getFeedDataUseCase()
                onLoading(false)
                _feedLiveData.value = feedDataList
            } catch (ex: Exception) {
                onLoading(false)
                onError("There was some problem loading your feed.")
                Log.e("FeedViewModel", "getFeedData: $ex")
            }
        }
    }

    private fun onLoading(isLoading: Boolean) {
        _loadingLiveData.value = isLoading
    }

    private fun onError(message: String) {
        _errorLiveData.value = message
    }
}