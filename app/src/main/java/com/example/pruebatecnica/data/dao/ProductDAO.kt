package com.example.pruebatecnica.data.dao

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
