package com.example.intershipvk.di.implementations

import com.example.intershipvk.di.interfaces.ProductsContainer
import com.example.intershipvk.di.interfaces.ProductsRepository
import com.example.intershipvk.network.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductsContainerImpl() : ProductsContainer {

    private val BASE_URL = "https://dummyjson.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitProductsService:ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }

    override val repository: ProductsRepository by lazy {
        ProductsRepositoryImpl(retrofitProductsService)
    }
}