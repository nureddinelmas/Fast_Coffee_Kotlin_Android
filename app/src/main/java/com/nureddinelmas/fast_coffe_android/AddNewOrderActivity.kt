package com.nureddinelmas.fast_coffe_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.nureddinelmas.fast_coffe_android.apiService.RestApiService
import com.nureddinelmas.fast_coffe_android.model.CoffeeSize
import com.nureddinelmas.fast_coffe_android.model.CoffeeType
import com.nureddinelmas.fast_coffe_android.model.Order
import kotlinx.android.synthetic.main.activity_add_new_order.*

class AddNewOrderActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_add_new_order)
		title = "Add New Order"
		
		
		
		val apiService = RestApiService()
		spinnerType.adapter = ArrayAdapter<CoffeeType>(this, android.R.layout.simple_expandable_list_item_1, CoffeeType.values())
		spinnerSize.adapter = ArrayAdapter<CoffeeSize>(this, android.R.layout.simple_expandable_list_item_1, CoffeeSize.values())
		
		buttonSubmit.setOnClickListener {
			
			val name = editTextName.text.toString()
			val email = editTextEmail.text.toString()

		
			val spinnerType = spinnerType.selectedItem
			val spinnerSize = spinnerSize.selectedItem
			
			val order = Order(name,email ,spinnerSize.toString() ,spinnerType.toString() )
			
			apiService.addOrder(order){
				
				if (it?.name != null){
					Toast.makeText(this, "Basari ile kaydedildi", Toast.LENGTH_LONG).show()
					val intent = Intent(this, MainActivity::class.java)
					startActivity(intent)
					Log.e("!!!", "merhaba")
				} else {
					Toast.makeText(this, "Basarisiz oldu, tekrar dene! ", Toast.LENGTH_LONG).show()
				}
			}
		}
	}
}