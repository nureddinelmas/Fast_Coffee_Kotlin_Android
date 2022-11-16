package com.nureddinelmas.fast_coffe_android.apiService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceBuilder {
	private val client = OkHttpClient.Builder().build()
	
	private  val retrofit = Retrofit.Builder()
		.baseUrl("https://warp-wiry-rugby.glitch.me/")
		.addConverterFactory(GsonConverterFactory.create())
		.client(client)
		.build()
	
	fun<T> buildService(service : Class<T>): T {
		return retrofit.create(service)
	}
}