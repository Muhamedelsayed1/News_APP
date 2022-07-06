package com.example.newsapp.repository

import com.example.newsapp.api.RetrofitInstance
import com.example.newsapp.db.ArticleDataBase

class NewsRepository(

    val db: ArticleDataBase // the var will access the functions of the database
) {
    suspend fun getBreakingNews(countryCode: String) =
        RetrofitInstance.api.getBreakingNews(countryCode)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)


}