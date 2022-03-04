package com.example.networkinglearn.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("employee_name")
    var employee_name: String? = null,

    @SerializedName("employee_salary")
    var employee_salary: Int? = null,

    @SerializedName("employee_age")
    var employee_age: Int? = null,

    @SerializedName("profile_image")
    var profile_image: String? = null
)