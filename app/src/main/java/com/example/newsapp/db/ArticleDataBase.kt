package com.example.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile // it is mean that other thread can see when the thread changes this instance

        private var instance: ArticleDataBase? = null //that is an instance of our database, so we only have a single instance of DB

        private val LOCK = Any() //that make sure that the db has only one instance
        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) { //this method mean that not anther threat sets this instance to some thing while we already set it
                instance ?: creatDataBase(context).also { instance = it }

            }

        private fun creatDataBase(context: Context) = Room.databaseBuilder( // this method to access the actual db funcs
            context.applicationContext,
            ArticleDataBase::class.java,
            "article_db_db"
        ).build()

    }
}