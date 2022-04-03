package com.example.photosapiapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photosapiapplication.api.RetrofitHelper
import com.example.photosapiapplication.model.ImageItem
import com.example.photosapiapplication.repository.ImagesRepository
import kotlinx.coroutines.launch

class ImageViewModel: ViewModel() {
    private val imagesRepository: ImagesRepository
    init{
        imagesRepository= ImagesRepository(RetrofitHelper.apiService)

    }
    fun getImage(id:String?){
        viewModelScope.launch {
            imagesRepository.getParticularItem(id)
        }
    }
    val image: LiveData<String>
        get() {
            return imagesRepository.imageLiveData
        }
}