package com.example.photosapiapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.photosapiapplication.R
import com.example.photosapiapplication.activity.ImageActivity
import com.example.photosapiapplication.databinding.ItemRowBinding
import com.example.photosapiapplication.model.ImageItem

class RecyclerAdapter(var list:ArrayList<ImageItem>, var context: Context):RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.UserViewHolder {
        return UserViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.UserViewHolder, position: Int) {
       holder.item.imageItem=list.get(position)
        holder.item.imageView.setOnClickListener({
            context.startActivity(Intent(context,ImageActivity::class.java).putExtra(context.getString(
                            R.string.id),list.get(position).id))
        })
    }

    override fun getItemCount(): Int {
       return list.size
    }
    class UserViewHolder(var item:ItemRowBinding):RecyclerView.ViewHolder(item.root){
    }

}