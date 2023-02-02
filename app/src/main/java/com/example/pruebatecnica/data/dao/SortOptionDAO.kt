package com.example.pruebatecnica.data.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SortOptionDAO(
    @SerializedName("sortBy")
    @Expose
    val sortBy:String?= null,
    @SerializedName("label")
    @Expose
    val label:String?= null,
)
