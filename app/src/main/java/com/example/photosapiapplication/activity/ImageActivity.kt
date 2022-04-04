package com.example.photosapiapplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.photosapiapplication.R
import com.example.photosapiapplication.constants.Constants
import com.example.photosapiapplication.databinding.ActivityImageBinding
import com.example.photosapiapplication.model.ImageItem
import com.example.photosapiapplication.viewmodels.ImageViewModel
import com.example.photosapiapplication.viewmodels.MainViewModel
import org.json.JSONObject


class ImageActivity : AppCompatActivity() {
    lateinit var viewModel:ImageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityImageBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_image)
        val id:String?=intent.getStringExtra(Constants.ID)
        viewModel= ViewModelProvider(this).get(ImageViewModel::class.java)
        viewModel.getImage(id)
        viewModel.image.observe(this, Observer {
            val jsonObject:JSONObject=JSONObject(it)
            binding.imageItem=ImageItem(jsonObject.getString(Constants.ID), jsonObject.getString("author"), 0, 0, jsonObject.getString("url"), jsonObject.getString("download_url"))
        })
        binding.back.setOnClickListener {
            finish()
        }
    }
}