package com.example.newsapp.util

// this class useful for differentiate between the successful and error response and helps us to handle the loading state
sealed class Resource<T>(
    val data: T? = null, // this is the body of the response
    val message: T? = null // this could be the error message
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: T?, data: T? = null) : Resource<T>(data, message)
    class Loading<T> :Resource<T>()

}

