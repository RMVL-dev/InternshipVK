package com.example.intershipvk

import com.example.intershipvk.data.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private val gson by lazy { Gson() }


fun toJson(data:Product):String =
    gson.toJson(data)

fun fromJson(data:String?):Product? {
    if (data == null)
        return null

    val typeEntity = object : TypeToken<Product?>(){}.type

    return try {
        gson.fromJson(data, typeEntity)
    }catch (e:Exception){
        e.printStackTrace()
        null
    }
}