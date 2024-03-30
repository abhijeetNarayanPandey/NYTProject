package com.example.newyorkproject.viewmodels

import com.example.newyorkproject.data.response.PopularArticlesResponse
import com.example.newyorkproject.utils.Resource


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorkproject.repositories.NewsShowsRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(
    private val repository: NewsShowsRepository
) : ViewModel() {
    var newsLiveData = MutableLiveData<Resource<PopularArticlesResponse>>()

    init {
        viewModelScope.launch {
            delay(5000)
            getNewsDetails()
        }
    }

    private fun getNewsDetails() = viewModelScope.launch {
        newsLiveData.postValue(Resource.Loading())
        try{
            val response = repository.getNews()
            newsLiveData.postValue(handleNasaResponse(response))
        }catch (e:Exception){

        }
    }

    private fun handleNasaResponse(response: Response<PopularArticlesResponse>): Resource<PopularArticlesResponse>? {
        if(response.isSuccessful){
            response.body()?.let { resultResponse->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


}












