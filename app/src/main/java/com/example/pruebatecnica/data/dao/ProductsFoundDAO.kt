package com.example.pruebatecnica.data.dao

import com.example.pruebatecnica.data.dto.ProductFoundDTO
import com.example.pruebatecnica.data.dto.SortOptionsDTO
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

val ProductsFoundDAO.toDTO : ProductFoundDTO
    get() = ProductFoundDTO(
        sortOptions = sortOptions.map { it.toDTO }.toMutableList(),
        productsFoundDAO = productsFoundDAO.map { it.toDTO }.toMutableList()
    )