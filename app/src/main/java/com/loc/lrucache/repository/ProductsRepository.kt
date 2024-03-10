package com.loc.lrucache.repository

import com.loc.lrucache.Product

interface ProductsRepository {
    suspend fun getProducts(): List<Product>
}