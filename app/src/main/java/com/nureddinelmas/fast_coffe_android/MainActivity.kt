package com.nureddinelmas.fast_coffe_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nureddinelmas.fast_coffe_android.adapter.OrderAdapter
import com.nureddinelmas.fast_coffe_android.apiService.RestApiService
import com.nureddinelmas.fast_coffe_android.model.Order
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
	 private var orderList = ArrayList<Order>()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		title = "Orders"
		recyclerViewOrder.visibility = View.GONE
		progress_circular.visibility = View.VISIBLE
		val apiService = RestApiService()
		
		
		
		apiService.getOrder(){
			
			if (it != null) {
				
				it.map { item -> orderList.add(item) }
				recyclerViewOrder.visibility = View.VISIBLE
				progress_circular.visibility = View.GONE
				val adapter = OrderAdapter(orderList)
				recyclerViewOrder.layoutManager = LinearLayoutManager(this)
				recyclerViewOrder.adapter = adapter
			}
		
		}
		
		fab.setOnClickListener {
			val intent = Intent(this, AddNewOrderActivity::class.java)
			startActivity(intent)
		}
	}
}