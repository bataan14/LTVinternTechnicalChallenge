package com.example.ltvintern

data class Article (val uuid:String,
                    val title:String,
                    val description:String,
                    val author:String,
                    val article_date:String,
                    val image:String,
                    val link:String)

class ArticleList(val articles:List<Article>)