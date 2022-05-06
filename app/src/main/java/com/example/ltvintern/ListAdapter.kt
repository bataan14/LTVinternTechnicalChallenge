package com.example.ltvintern

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val articleList:ArticleList) : RecyclerView.Adapter<ListHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ListHolder(layoutInflater.inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val item = articleList.articles[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = articleList.articles.size
    }