package com.example.testecarrefour.network

import com.example.testecarrefour.core.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

suspend inline fun <reified T> call(crossinline apiCall: suspend () -> T): ResultWrapper<T> {

    return withContext(Dispatchers.IO) {
        try {
            val result = apiCall.invoke()

            ResultWrapper.Success(result)

        } catch (exception: Exception) {
            ResultWrapper.Error(exception.message.toString())
        }

    }
}



inline fun <reified T> createWebService(): T {
    val timeSeconds= 65L
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    var httpClientBuilder = OkHttpClient.Builder()
    httpClientBuilder.connectTimeout(timeSeconds, TimeUnit.SECONDS)
        .readTimeout(timeSeconds, TimeUnit.SECONDS)
        .writeTimeout(timeSeconds, TimeUnit.SECONDS)

    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.github.com/")
        .client(httpClientBuilder.build())
        .build()
        .create(T::class.java)
}