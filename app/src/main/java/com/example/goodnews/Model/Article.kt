package com.example.goodnews.Model

class Identifier( val id: String, val name : String)
class Article (
    val source: Identifier,
    val author: String?,
    val title : String?,
    val description : String?,
    val url : String?,
    val urlToImage : String?,
    val publishedAt : String?,
    val content : String?)