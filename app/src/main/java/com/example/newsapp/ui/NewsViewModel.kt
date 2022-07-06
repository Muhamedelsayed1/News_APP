package com.example.newsapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.NewsResponse
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.util.Resources
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository

) : ViewModel() {
    val breakingNews: MutableLiveData<Resources<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1
    //livedata to search news fragment
    val searchNews: MutableLiveData<Resources<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1
    init {
        getBreakingNews("eg")
    }
    fun getBreakingNews(CountryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resources.Loading())
        val response = newsRepository.getBreakingNews(CountryCode)
        breakingNews.postValue(handleBreakingNewsResponse(response))
        Log.i("zzz", "getBreakingNews: "+response.body())
    }
    fun searchNews (searchQuery:String)= viewModelScope.launch {
        searchNews.postValue(Resources.Loading())
        val response = newsRepository.searchNews(searchQuery,searchNewsPage)
        searchNews.postValue(handleSearchNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resources<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultRespose ->
                return Resources.Success(resultRespose)

            }
        }
        return Resources.Error(response.message())
    }
    private fun handleSearchNewsResponse(response: Response<NewsResponse>): Resources<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultRespose ->
                return Resources.Success(resultRespose)

            }
        }
        return Resources.Error(response.message())
    }
}