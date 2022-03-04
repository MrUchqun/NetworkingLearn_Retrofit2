package com.example.networkinglearn.network

import com.example.networkinglearn.network.service.EmployeeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {
    const val IS_TESTER = true
    private const val SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/api/v1/"
    private const val SERVER_PRODUCTION = "http://dummy.restapiexample.com/"

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun server(): String {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    val employeeService: EmployeeService = retrofit.create(EmployeeService::class.java)
}