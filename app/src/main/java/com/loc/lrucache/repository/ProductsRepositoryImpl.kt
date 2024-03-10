package com.loc.lrucache.repository

import android.util.Log
import com.loc.lrucache.Product
import com.loc.lrucache.ProductsApi
import com.loc.lrucache.ProductsCache

class ProductsRepositoryImpl : ProductsRepository {
    override suspend fun getProducts(): List<Product> {
        return try {
            val cachedProducts = ProductsCache.getProducts()
            if (cachedProducts == null) {
                Log.d("test","Fetching from Network")
                ProductsCache.saveProducts(
                    ProductsApi.instance.getProducts()
                )
            } else {
                Log.d("test","Fetching from Cache")
            }
            ProductsCache.getProducts() ?: emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            return emptyList()
        }

    }
}