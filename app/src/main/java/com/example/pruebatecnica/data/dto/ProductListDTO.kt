package com.example.pruebatecnica.data.dto


data class ProductListDTO(
    val sortOptions : MutableList<SortOptionsDTO> = mutableListOf(),
    val productsFound :MutableList<ProductDTO> = mutableListOf()
)