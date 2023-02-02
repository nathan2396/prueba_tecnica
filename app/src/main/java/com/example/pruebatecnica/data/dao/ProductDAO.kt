package com.example.pruebatecnica.data.dao

import com.example.pruebatecnica.data.dto.ProductDTO
import com.example.pruebatecnica.data.dto.SortOptionsDTO
import com.example.pruebatecnica.data.dto.VariantsColorDTO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductDAO(
    @SerializedName("smImage")
    @Expose
    val smImage :String? = null,
    @SerializedName("lgImage")
    @Expose
    val lgImage :String? = null,
    @SerializedName("xlImage")
    @Expose
    val xlImage :String? = null,
    @SerializedName("productDisplayName")
    @Expose
    val nameProduct :String = "",
    @SerializedName("listPrice")
    @Expose
    val productPrice :Double = 0.0,
    @SerializedName("promoPrice")
    @Expose
    val productPromoPrice:Double = 0.0,
    @SerializedName("variantsColor")
    @Expose
    val productColors:List<VariantsColorDAO> = listOf()
)

val ProductDAO.toDTO : ProductDTO
    get() = ProductDTO(
        smImage = smImage,
        lgImage = lgImage,
        xlImage = xlImage,
        nameProduct = nameProduct,
        productPrice = productPrice,
        productPromoPrice = productPromoPrice,
        productColors = productColors.map { it.toDTO }.toMutableList())




