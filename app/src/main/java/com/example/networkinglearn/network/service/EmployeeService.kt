package com.example.networkinglearn.network.service

import com.example.networkinglearn.model.Employee
import com.example.networkinglearn.model.EmployeeDelete
import com.example.networkinglearn.model.EmployeeList
import com.example.networkinglearn.model.EmployeeResponse
import retrofit2.Call
import retrofit2.http.*

interface EmployeeService {

    @Headers("Content-type:application/json")

    @GET("employees")
    fun getAllEmployee(): Call<EmployeeList>

    @GET("employee/{id}")
    fun getEmployee(@Path("id") id: Int): Call<EmployeeResponse>

    @POST("create")
    fun createEmployee(@Body employee: Employee): Call<EmployeeResponse>

    @DELETE("delete/{id}")
    fun deleteEmployee(@Path("id") id: Int): Call<EmployeeDelete>
}