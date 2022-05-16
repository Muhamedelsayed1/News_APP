package com.example.newsapp.repository

import com.example.newsapp.db.ArticleDataBase

class NewsRepository(

    val db : ArticleDataBase // the var will access the functions of the database
) {
}