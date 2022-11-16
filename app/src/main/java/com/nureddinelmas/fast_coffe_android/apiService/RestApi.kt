package com.nureddinelmas.fast_coffe_android.apiService


import android.database.Observable
import com.nureddinelmas.fast_coffe_android.model.Order
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
	@Headers("Content-Type: application/json")
	@POST("orders/")
	fun addOrder(@Body orderData: Order): Call<Order>
	
	
	@Headers("Content-Type: application/json")
	@GET("orders")
	fun getOrder(): Call<List<Order>>
}