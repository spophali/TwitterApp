package com.example.twitterapp.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Feed
import com.example.domain.usecase.GetFeedDataUseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@OptIn(KoinApiExtension::class)
class FeedViewModel(
    private val getFeedDataUseCase: GetFeedDataUseCase
) : ViewModel(), KoinComponent {

    private val _text = MutableLiveData<String>().apply {
        value = "This is feed Fragment"
    }
    val text: LiveData<String> = _text

    private val _feedLiveData = MutableLiveData<List<Feed>>()

    val feedLiveData: LiveData<List<Feed>> = _feedLiveData

    private val _errorLiveData = MutableLiveData<String>()

    val errorLiveData = _errorLiveData

    private val _loadingLiveData = MutableLiveData<Boolean>()

    val loadingLiveData = _loadingLiveData
    init {
        getFeedData()
    }

    private fun getFeedData() {
        viewModelScope.launch {
            try {
                _loadingLiveData.value = true
                val feedDataList = getFeedDataUseCase()
                Log.i("FVM", "getFeedData: " + feedDataList.size)
                feedDataList.forEach {
                    Log.i("FVM", "getFeedData: ${it.name}")
                }
                _feedLiveData.value = feedDataList
                _loadingLiveData.value = false
            } catch (ex: Exception) {
                _loadingLiveData.value = false
                _errorLiveData.value = "There was some problem loading your feed."

                Log.e("FeedViewModel", "getFeedData: $ex")
            }
        }
    }
}