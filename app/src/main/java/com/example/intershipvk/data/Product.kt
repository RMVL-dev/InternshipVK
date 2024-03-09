package com.example.intershipvk.data

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title:String,
    @SerializedName("description") val description:String,
    @SerializedName("price") val price:Int,
    @SerializedName("discountPercentage") val discount: Float,
    @SerializedName("rating") val rating: Float,
    @SerializedName("stock") val stock:Int,
    @SerializedName("brand") val brand:String,
    @SerializedName("category") val category:String,
    @SerializedName("thumbnail") val thumbnailUrl:String,
    @SerializedName("images") val images:List<String>
)
