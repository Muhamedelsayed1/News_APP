package com.example.newsapp.db

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromSource(source: com.example.newsapp.models.Source): String {
        return source.name
    }
    @TypeConverter
    fun toSource(name:String) : com.example.newsapp.models.Source {
        return com.example.newsapp.models.Source(name, name)
    }
}