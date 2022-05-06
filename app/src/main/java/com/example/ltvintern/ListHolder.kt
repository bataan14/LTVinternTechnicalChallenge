package com.example.ltvintern

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListHolder(view: View):RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.article_title)
    private val description = view.findViewById<TextView>(R.id.article_description)
    private val author = view.findViewById<TextView>(R.id.article_author)
    private val article_date = view.findViewById<TextView>(R.id.article_date)
    private val image = view.findViewById<ImageView>(R.id.article_image)

    fun render(articleModel:Article){
        title.text = articleModel.title
        description.text = articleModel.description
        author.text = articleModel.author
        article_date.text = articleModel.article_date
        Glide.with(image.context).load(articleModel.image).override(60,60).into(image)
        itemView.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(articleModel.link)
            itemView.context.startActivity(openURL)
        }
    }
}