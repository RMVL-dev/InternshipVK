package com.example.intershipvk.network

import com.example.intershipvk.data.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("/products")
    suspend fun getProductList(
        @Query("skip") offset:Int,
        @Query("limit") limit:Int
    ):Response

    @GET("/products/search")
    suspend fun getSearchResult(
        @Query("q") query:String
    ):Response

}