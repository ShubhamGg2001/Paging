package com.example.photosapiapplication.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.provider.SyncStateContract
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.photosapiapplication.R
import com.example.photosapiapplication.constants.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

data class ImageItem (
    @SerializedName("id"           ) var id          : String?=null,
    @SerializedName("author"       ) var author      : String?,
    @SerializedName("width"        ) var width       : Int=0,
    @SerializedName("height"       ) var height      : Int=0,
    @SerializedName("url"          ) var url         : String?,
    @SerializedName("download_url" ) var downloadUrl : String?
)
@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView?, url: String?) {
    if (url == null)
        Glide.with(imageView!!).load(Constants.DEFAULT_IMAGEURL)
            .into(imageView)
    else Glide.with(imageView!!).load(url).into(imageView)


}

