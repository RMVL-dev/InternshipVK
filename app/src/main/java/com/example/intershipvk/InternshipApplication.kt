package com.example.intershipvk

import android.app.Application
import com.example.intershipvk.di.implementations.ProductsContainerImpl
import com.example.intershipvk.di.interfaces.ProductsContainer

class InternshipApplication:Application() {

    lateinit var productsContainer: ProductsContainer
        private set

    override fun onCreate() {
        super.onCreate()
        productsContainer = ProductsContainerImpl()
    }


}