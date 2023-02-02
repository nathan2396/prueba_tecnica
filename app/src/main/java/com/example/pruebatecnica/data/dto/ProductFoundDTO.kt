package com.example.pruebatecnica.data.dto


data class ProductFoundDTO(
    val sortOptions :MutableList<SortOptionsDTO> = mutableListOf(),
    val productsFoundDAO: MutableList<ProductDTO> = mutableListOf()
)