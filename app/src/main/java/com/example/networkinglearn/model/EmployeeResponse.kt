package com.example.networkinglearn.model

import com.google.gson.annotations.SerializedName

data class EmployeeResponse(

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("data")
    var data: Employee,

    @SerializedName("message")
    var message: String? = null
)