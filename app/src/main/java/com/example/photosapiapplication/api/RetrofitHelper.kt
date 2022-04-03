package com.example.photosapiapplication.api

import com.example.photosapiapplication.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitHelper {
    private const val BASE_URL= Constants.BASE_URL
    val apiService:ApiService
    init{
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            ScalarsConverterFactory.create()).build()
        apiService=retrofit.create(ApiService::class.java)
    }


}