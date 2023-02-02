package com.example.pruebatecnica.data.dao

import com.example.pruebatecnica.data.dto.SortOptionsDTO
import com.example.pruebatecnica.data.dto.VariantsColorDTO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VariantsColorDAO(
    @SerializedName("colorName")
    @Expose
    val colorName :String? = null,
    @SerializedName("colorHex")
    @Expose
    val colorHex :String? = null,
    @SerializedName("colorImageURL")
    @Expose
    val colorImageURL :String? = null,
    @SerializedName("colorMainURL")
    @Expose
    val colorMainURL :String? = null,
    @SerializedName("skuId")
    @Expose
    val skuId :String? = null
)

val VariantsColorDAO.toDTO : VariantsColorDTO
    get() = VariantsColorDTO(
        colorName = colorName,
        colorHex = colorHex,
        colorImageURL = colorImageURL,
        colorMainURL = colorMainURL,
        skuId = skuId
    )