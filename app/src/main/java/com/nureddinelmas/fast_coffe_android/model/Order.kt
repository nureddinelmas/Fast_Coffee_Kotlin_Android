package com.nureddinelmas.fast_coffe_android.model

import com.google.gson.annotations.SerializedName

data class Order(
	@SerializedName("email") val email: String?,
	@SerializedName("name") val name: String?,
	@SerializedName("size") val size: String,
	@SerializedName("type") val type: String
)

enum class CoffeeType(val type: String)  {
	latte("Latte"), capicconu("Capicconu"), corate("Corate"), expresso("Expresso")
}

enum class CoffeeSize(val size: String) {
	small("Small"), medium("Medium"), big("Big")
}