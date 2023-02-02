package com.example.pruebatecnica.data.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductsFoundDAO(
    @SerializedName("sortOptions")
    @Expose
    val sortOptions :List<SortOptionDAO> = listOf() ,
    @SerializedName("records")
    @Expose
    val productsFoundDAO: List<ProductDAO> = listOf(),
)