package com.example.networkinglearn.model

import com.google.gson.annotations.SerializedName

data class EmployeeList(

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("data")
    var data: ArrayList<Employee>,

    @SerializedName("message")
    var message: String? = null
)