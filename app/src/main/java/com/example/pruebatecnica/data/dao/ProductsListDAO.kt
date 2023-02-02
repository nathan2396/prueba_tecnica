package com.example.pruebatecnica.data.dao

import com.example.pruebatecnica.data.dto.ProductListDTO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductsListDAO(
    @SerializedName("status")
    @Expose
    val status :StatusDAO? =  null,
    @SerializedName("pageType")
    @Expose
    val pageType:String?= null,
    @SerializedName("plpResults")
    @Expose
    val productsFound:ProductsFoundDAO? = null)

val ProductsListDAO.toDTO : ProductListDTO
    get() = ProductListDTO(
        sortOptions = productsFound?.sortOptions?.map { it.toDTO }?.toMutableList() ?: mutableListOf(),
        productsFound = productsFound?.productsFoundDAO?.map { it.toDTO }?.toMutableList() ?: mutableListOf()
    )
