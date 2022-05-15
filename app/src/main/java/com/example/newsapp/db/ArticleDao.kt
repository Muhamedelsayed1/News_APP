package com.example.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.models.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long   //this method check if the article already in the db it will update it and will return all available articles in db
        @Query("SELECT * FROM articles")
        fun getAllArticles():LiveData<List<Article>> // that mean if any change happen in article livedata will notify and make the change
        @Delete
        suspend fun deleteArticle(article: Article)



    }
