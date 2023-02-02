package com.example.pruebatecnica.repository

import com.example.pruebatecnica.data.dao.ProductsFoundDAO
import com.example.pruebatecnica.data.dao.ProductsListDAO
import com.example.pruebatecnica.domain.ProductsApi
import retrofit2.Response

class ProductsRepositoryImpl constructor(private val api: ProductsApi) : ProductsRepository {

    override suspend fun getProductList(coincidence:String?): Response<ProductsListDAO> {
        return api.getProductList(coincidence = coincidence)
    }


}