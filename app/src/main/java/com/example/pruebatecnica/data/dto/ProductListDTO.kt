package com.example.pruebatecnica.data.dto

import com.example.pruebatecnica.data.dao.ProductDAO
import com.example.pruebatecnica.data.dao.SortOptionDAO


data class ProductListDTO(
    val sortOptions : MutableList<SortOptionDAO> = mutableListOf(),
    val productsFound :MutableList<ProductDAO> = mutableListOf()
)