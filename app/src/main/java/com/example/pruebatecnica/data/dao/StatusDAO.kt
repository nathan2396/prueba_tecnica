package com.example.pruebatecnica.data.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StatusDAO(@SerializedName("status")
                     @Expose
                     val status :String,
                     @SerializedName("statusCode")
                    @Expose
                    val statusCode :Int,)