package com.example.intershipvk.ui.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.intershipvk.InternshipApplication
import com.example.intershipvk.ui.catalog.CatalogViewModel

class ProductsViewModelProvider {

    val factory = viewModelFactory {
        initializer {
            CatalogViewModel(repository = internShipApp().productsContainer.repository )
        }
    }
}

fun CreationExtras.internShipApp():InternshipApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as InternshipApplication)