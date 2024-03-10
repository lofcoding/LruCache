package com.loc.lrucache.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.lrucache.Product
import com.loc.lrucache.repository.ProductsRepository
import com.loc.lrucache.repository.ProductsRepositoryImpl
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {

    private val productsRepository: ProductsRepository = ProductsRepositoryImpl()

    val products = mutableStateListOf<Product>()
    var loading by mutableStateOf(false)

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            loading = true
            products.addAll(
                productsRepository.getProducts()
            )
            loading = false
        }
    }
}