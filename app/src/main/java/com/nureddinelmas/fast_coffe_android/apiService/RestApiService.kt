package com.nureddinelmas.fast_coffe_android.apiService

import android.util.Log
import android.widget.Toast
import com.nureddinelmas.fast_coffe_android.model.Order
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
	
	fun addOrder(order: Order, onResult: (Order?) -> Unit) {
		val retrofit = ServiceBuilder.buildService(RestApi::class.java)
		retrofit.addOrder(order).enqueue(
			object : Callback<Order> {
				override fun onResponse(call: Call<Order>, response: Response<Order>) {
					val addedOrder = response.body()
					onResult(addedOrder)
				}
				
				override fun onFailure(call: Call<Order>, t: Throwable) {
					onResult(null)
				}
				
			}
		)
	}
	
	
	
	fun getOrder(onResult: (List<Order>?) -> Unit){
		val retrofit = ServiceBuilder.buildService(RestApi::class.java)
		
		retrofit.getOrder().enqueue(
			object : Callback<List<Order>> {
				override fun onResponse(call: Call<List<Order>>, response: Response<List<Order>>) {
					val orders = response.body()
					onResult(orders)
				}
				
				override fun onFailure(call: Call<List<Order>>, t: Throwable) {
					TODO("Not yet implemented")
				}
				
			}
		)
	}
}