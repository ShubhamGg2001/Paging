package com.example.photosapiapplication.repository

import androidx.lifecycle.MutableLiveData
import com.example.photosapiapplication.api.ApiService
import com.example.photosapiapplication.model.ImageItem

class ImagesRepository(private val apiService: ApiService){
     val imagesLiveData=MutableLiveData<String>()
    val imageLiveData=MutableLiveData<String>()
    suspend fun getImages(page:Int, limit:Int){
        val result=apiService.getItems(page,limit)
        if(result?.body() !=null){
            imagesLiveData.postValue(result.body())
        }
    }
    suspend fun getParticularItem(id:String?){
        val result=apiService.getItemWithId(id)
        if(result.isSuccessful && result.body() !=null){
            imageLiveData.postValue(result.body())
        }
    }
}