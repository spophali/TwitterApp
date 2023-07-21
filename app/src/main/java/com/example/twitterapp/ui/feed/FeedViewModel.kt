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
import java.lang.Exception

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

    init {
        getFeedData()
    }

    private fun getFeedData(){
        viewModelScope.launch {
            try {
                val feedDataList = getFeedDataUseCase()
                Log.i("FVM", "getFeedData: "+feedDataList.size)
                feedDataList.forEach {
                    Log.i("FVM", "getFeedData: ${it.name}")
                }
                _feedLiveData.value = feedDataList
            }catch (ex: Exception){
                Log.e("FeedViewModel", "getFeedData: $ex" )
            }
        }
    }
}