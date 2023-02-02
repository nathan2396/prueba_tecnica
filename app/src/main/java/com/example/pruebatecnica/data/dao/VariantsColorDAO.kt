package com.example.pruebatecnica.data.dao

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