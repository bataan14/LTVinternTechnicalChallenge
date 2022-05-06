package com.example.ltvintern

import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class ArticleProvider   {

    private val client = OkHttpClient()
    private val API_ENDPOINT = "https://hiring.ltvops.com/articles/index.mobile-android.json"

    fun fetchArticles(resolve:(articleList:ArticleList) -> Unit) {
        val request = Request.Builder().url(API_ENDPOINT).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) throw IOException("Unexpected code $response")
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val articles = gson.fromJson(body, ArticleList::class.java)
                resolve(articles)
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("ERROR")
            }
        })
    }
}