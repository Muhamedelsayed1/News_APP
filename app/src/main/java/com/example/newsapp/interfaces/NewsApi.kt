package com.example.newsapp.interfaces

import androidx.room.PrimaryKey
import com.example.newsapp.NewsResponse
import com.example.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top_headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "EG",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey ")  // this to know who make the request
        apiKey: String = API_KEY

    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery: String ,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apikey ")  // this to know who make the request
        apiKey: String = API_KEY

    ): Response<NewsResponse>
}