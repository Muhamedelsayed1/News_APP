package com.example.newsapp.api

import com.example.newsapp.interfaces.NewsApi
import com.example.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// this is instance class that enable to make request from every where in my code
class RetrofitInstance {
    companion object {
        private val retrofit by lazy { // lazy: m3naha an elle gwa el curlly bracket hn3mlo init lma and 3l el func bs
            // now we will log the responses of retrofit
            val logging = HttpLoggingInterceptor()
            //now we will attach this to retrofit object to be able to see which request we are actually making and what responses are
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build()
        }

        val api by lazy {
            retrofit.create(NewsApi::class.java)
        }
    }
}