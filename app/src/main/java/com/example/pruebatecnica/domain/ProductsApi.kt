package com.example.pruebatecnica.domain

import com.example.pruebatecnica.data.dao.ProductsFoundDAO
import com.example.pruebatecnica.data.dao.ProductsListDAO
import com.example.pruebatecnica.domain.api.ApiServiceBuilder
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    class Builder() : ApiServiceBuilder<ProductsApi>() {
        override fun build(): ProductsApi {
            return client.create(ProductsApi::class.java)
        }
    }
    @GET("services/v3/plp")
    suspend fun getProductList(
        @Query("search-string") coincidence :String?= null,
        @Query("page-number") pageNumber:Int = 1
    ) : Response<ProductsListDAO>




}