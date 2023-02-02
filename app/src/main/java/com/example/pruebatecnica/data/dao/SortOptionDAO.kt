package com.example.pruebatecnica.data.dao

import com.example.pruebatecnica.data.dto.ProductListDTO
import com.example.pruebatecnica.data.dto.SortOptionsDTO
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

val SortOptionDAO.toDTO : SortOptionsDTO
    get() = SortOptionsDTO(
        sortBy = sortBy,
        label = label
    )

