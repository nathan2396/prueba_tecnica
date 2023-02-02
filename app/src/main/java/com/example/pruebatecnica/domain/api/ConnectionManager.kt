package com.example.pruebatecnica.domain.api

import com.example.pruebatecnica.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class ConnectionManager() {


    val timeOut = 240L
    var client = updateRetrofitApi(UrlManager.baseUrl, getInterceptor())

    fun getInterceptor(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.PRODUCTION) {
                HttpLoggingInterceptor.Level.NONE
            } else {
                HttpLoggingInterceptor.Level.BODY
            }
        }


        val okBuilder = OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .callTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .build()
        return okBuilder
    }


    fun updateRetrofitApi(
        baseUrl: String,
        okBuilder: OkHttpClient = getInterceptor()
    ): Retrofit {
        var retrofitPrueba = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okBuilder)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofitPrueba
    }

}