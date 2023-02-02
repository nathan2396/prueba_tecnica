package com.example.pruebatecnica.repository

import com.example.pruebatecnica.data.dao.ProductsFoundDAO
import com.example.pruebatecnica.data.dao.ProductsListDAO
import retrofit2.Response

interface ProductsRepository {

    suspend fun getProductList(coincidence:String? = null) : Response<ProductsListDAO>

}