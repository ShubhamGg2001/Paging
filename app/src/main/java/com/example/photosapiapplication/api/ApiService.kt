package com.example.photosapiapplication.api

import com.example.photosapiapplication.constants.Constants
import com.example.photosapiapplication.model.ImageItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.LIST_URL)
    suspend fun getItems(@Query(Constants.PAGE_STRING) page:Int, @Query(Constants.LIMIT_STRING) limit:Int): Response<String>
    @GET(Constants.ITEM_URL)
    suspend fun getItemWithId(@Path(Constants.ID) id:String?):Response<String>
}