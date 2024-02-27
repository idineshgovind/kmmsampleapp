package com.github.dinesh.kmmsampleapp.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.dinesh.kmmsampleapp.UseCaseProvider
import com.github.dinesh.kmmsampleapp.data.State
import com.github.dinesh.kmmsampleapp.repository.PixadayImagesUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private var currentPage = 1

    val liveData = MutableLiveData<State>()
    private val networkUseCase: PixadayImagesUseCase = UseCaseProvider.pixabayImagesUseCase

    fun loadNextPage(query: String, firstLoad: Boolean) {
        viewModelScope.launch {
            if (firstLoad) {
                currentPage = 1
                liveData.postValue(State.loading)
            }

            kotlin.runCatching { 
                networkUseCase.getPixadayImages(query, currentPage.toString())
            }.onSuccess {
                if (it.isSuccess) {
                    liveData.postValue(State.result(it.data?.hits!!))
                    currentPage += 1
                } else {
                    liveData.postValue(State.error(it.exception?.message!!))
                }
            }.onFailure {
                liveData.postValue(State.error(it.message!!))
            }
        }
    }
}