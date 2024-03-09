package com.example.intershipvk.di.interfaces

import com.example.intershipvk.data.Response

interface ProductsRepository {

    suspend fun getProducts(offset:Int, limit:Int):Response

}