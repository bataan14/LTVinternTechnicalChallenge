package com.example.ltvintern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            ArticleProvider().fetchArticles{articles->
                this@MainActivity.runOnUiThread(java.lang.Runnable {
                initRecyclerView(articles)
            })
        }
    }

    private fun initRecyclerView(articleList: ArticleList){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        progressBar.visibility = View.INVISIBLE
        recyclerView.adapter = ListAdapter(articleList)

    }
}


