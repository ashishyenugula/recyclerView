package com.ashish.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ashish.myapplication.databinding.ItemListRecylerviewBinding
import com.ashish.myapplication.model.ResponseMain
import com.bumptech.glide.Glide


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MainViewHolder>() {
    private var list = mutableListOf<ResponseMain>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListRecylerviewBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MainViewHolder, position: Int) {
        val listResponse = list[position]
        holder.binding.title.text = listResponse.title
        holder.binding.time.text = listResponse.readablePublishDate
        holder.binding.description.text = listResponse.description
        Glide.with(holder.itemView.context).load(listResponse.socialImage)
            .into(holder.binding.postImage)
    }

    override fun getItemCount(): Int {
        return list.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setImages(updateList: List<ResponseMain>) {
        this.list = updateList.toMutableList()
        notifyDataSetChanged()
    }


    inner class MainViewHolder(val binding: ItemListRecylerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}