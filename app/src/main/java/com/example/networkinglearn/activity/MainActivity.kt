package com.example.networkinglearn.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.networkinglearn.R
import com.example.networkinglearn.model.Employee
import com.example.networkinglearn.model.EmployeeDelete
import com.example.networkinglearn.model.EmployeeList
import com.example.networkinglearn.model.EmployeeResponse
import com.example.networkinglearn.network.RetrofitHttp
import com.example.networkinglearn.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var tvText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        tvText = findViewById(R.id.tv_text)
        deleteEmployee(1)
    }

    private fun getAllEmployee() {
        RetrofitHttp.employeeService.getAllEmployee().enqueue(object : Callback<EmployeeList> {
            override fun onResponse(call: Call<EmployeeList>, response: Response<EmployeeList>) {
                Logger.d("getAllEmployee", response.toString())
                Logger.d("getAllEmployee/body", response.body().toString())
                tvText.text = response.body().toString()
            }

            override fun onFailure(call: Call<EmployeeList>, t: Throwable) {
                Logger.e("getAllEmployee/onFailure", t.message.toString())
            }

        })
    }

    private fun getEmployee(id: Int) {
        RetrofitHttp.employeeService.getEmployee(id).enqueue(object : Callback<EmployeeResponse> {
            override fun onResponse(call: Call<EmployeeResponse>, response: Response<EmployeeResponse>) {
                Logger.d("getEmployee", response.toString())
                Logger.d("getEmployee/body", response.body().toString())
                tvText.text = response.body().toString()
            }

            override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                Logger.e("getEmployee/onFailure", t.message.toString())
            }

        })
    }

    private fun createEmployee(employee: Employee) {
        RetrofitHttp.employeeService.createEmployee(employee)
            .enqueue(object : Callback<EmployeeResponse> {
                override fun onResponse(
                    call: Call<EmployeeResponse>,
                    response: Response<EmployeeResponse>
                ) {
                    Logger.d("createEmployee", response.toString())
                    Logger.d("createEmployee/body", response.body().toString())
                    tvText.text = response.body().toString()
                }

                override fun onFailure(call: Call<EmployeeResponse>, t: Throwable) {
                    Logger.e("createEmployee/onFailure", t.message.toString())
                }
            })
    }

    private fun deleteEmployee(id: Int) {
        RetrofitHttp.employeeService.deleteEmployee(id).enqueue(object : Callback<EmployeeDelete> {
            override fun onResponse(call: Call<EmployeeDelete>, response: Response<EmployeeDelete>) {
                Logger.d("deleteEmployee", response.toString())
                Logger.d("deleteEmployee/body", response.body().toString())
                tvText.text = response.body().toString()
            }

            override fun onFailure(call: Call<EmployeeDelete>, t: Throwable) {
                Logger.e("deleteEmployee/onFailure", t.message.toString())
            }

        })
    }
}