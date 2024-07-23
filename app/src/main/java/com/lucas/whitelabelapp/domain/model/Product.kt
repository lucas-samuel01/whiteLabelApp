package com.lucas.whitelabelapp.domain.model

data class Product(
    val id:String = "",
    val description:String = "",
    val price:Double = 0.0,
    var imageUrl:String = ""
)
