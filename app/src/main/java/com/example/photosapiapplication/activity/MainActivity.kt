package com.example.photosapiapplication.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photosapiapplication.R
import com.example.photosapiapplication.adapter.RecyclerAdapter
import com.example.photosapiapplication.constants.Constants
import com.example.photosapiapplication.databinding.ActivityMainBinding
import com.example.photosapiapplication.model.ImageItem
import com.example.photosapiapplication.viewmodels.MainViewModel
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
     var list:ArrayList<ImageItem> =ArrayList()
    lateinit var viewModel:MainViewModel
    var page:Int=Constants.INITIAL_PAGE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        binding.progressCircular.setVisibility(View.VISIBLE)
        binding.rclview.setLayoutManager(LinearLayoutManager(this))
        setUpRecyclerView(list)
        getData(page,Constants.LIMIT)
        binding.nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight - v.measuredHeight) {
                binding.progressCircular.setVisibility(View.VISIBLE)
                page = page + 1
                getData(page, Constants.LIMIT)
            }
        })
        viewModel.images.observe(this, Observer {

            val jsonArray: JSONArray = JSONArray(it)
            for (count in 0..jsonArray.length() - 1) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(count)
                list.add(
                    ImageItem(jsonObject.getString(Constants.ID), jsonObject.getString(getString(R.string.author)), jsonObject.getInt("width"), jsonObject.getInt("height"), jsonObject.getString(getString(
                                            R.string.url)), jsonObject.getString(getString(R.string.download_url))))
            }
            setUpRecyclerView(list)
        })
    }

    private fun setUpRecyclerView(list: ArrayList<ImageItem>) {
        binding.rclview.adapter = RecyclerAdapter(list,this)
    }

    private fun getData(page: Int, limit: Int) {
        viewModel.getImagesList(page,limit)

    }

}