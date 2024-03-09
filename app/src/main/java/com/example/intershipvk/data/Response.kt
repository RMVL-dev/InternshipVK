package com.example.intershipvk.data

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("products") val products:List<Product>,
    @SerializedName("total") val total:Int,
    @SerializedName("skip") val skipped:Int,
    @SerializedName("limit") val numberOfElementPerPage:Int
)
