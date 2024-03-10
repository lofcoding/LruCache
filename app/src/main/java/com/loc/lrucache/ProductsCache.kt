package com.loc.lrucache

import android.util.LruCache
import com.loc.lrucache.ProductsCache.Keys.ProductsKey

object ProductsCache {

    private object Keys {
        const val ProductsKey = "products"
    }

    private val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
    // Use 1/8 of the available memory
    private val cacheSize = maxMemory / 8

    private val cache = LruCache<String, List<Product>>(cacheSize)

    fun saveProducts(products: List<Product>) {
        cache.put(ProductsKey, products)
    }

    fun getProducts(): List<Product>? {
        return cache[ProductsKey]
    }
}