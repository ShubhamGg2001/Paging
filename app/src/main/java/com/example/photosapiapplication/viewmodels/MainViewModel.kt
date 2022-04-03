package com.example.photosapiapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photosapiapplication.api.ApiService
import com.example.photosapiapplication.api.RetrofitHelper
import com.example.photosapiapplication.model.ImageItem
import com.example.photosapiapplication.repository.ImagesRepository
import kotlinx.coroutines.launch

class MainViewModel :ViewModel(){
    private val imagesRepository:ImagesRepository
    init{
        imagesRepository=ImagesRepository(RetrofitHelper.apiService)

    }
    fun getImagesList(page:Int,limit:Int){
        viewModelScope.launch {
            imagesRepository.getImages(page,limit)
        }
    }
    val images:LiveData<String>
        get() {
           return imagesRepository.imagesLiveData
        }
}