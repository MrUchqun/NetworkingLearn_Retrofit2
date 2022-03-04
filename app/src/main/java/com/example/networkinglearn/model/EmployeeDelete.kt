package com.example.networkinglearn.model

import com.google.gson.annotations.SerializedName

data class EmployeeDelete(

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("data")
    var data: String,

    @SerializedName("message")
    var message: String? = null
)