package com.example.pruebatecnica.data.dto


data class ProductDTO(
    val smImage :String? = null,
    val lgImage :String? = null,
    val xlImage :String? = null,
    val nameProduct :String = "",
    val productPrice :Double = 0.0,
    val productPromoPrice:Double = 0.0,
    val productColors:MutableList<VariantsColorDTO> = mutableListOf()
)
