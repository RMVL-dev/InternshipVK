package com.example.intershipvk.di.implementations

import com.example.intershipvk.data.Response
import com.example.intershipvk.di.interfaces.ProductsRepository
import com.example.intershipvk.network.ProductService

class ProductsRepositoryImpl(
    private val api:ProductService
): ProductsRepository {
    override suspend fun getProducts(offset: Int, limit: Int): Response =
        api.getProductList(offset = offset, limit = limit)
}