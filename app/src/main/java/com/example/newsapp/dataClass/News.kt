package com.example.newsapp.dataClass

import java.io.Serializable

data class News(
    var id:Int,
    var title:String,
    var image:String,
    var description:String ?= null
):Serializable
