package com.nureddinelmas.fast_coffe_android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nureddinelmas.fast_coffe_android.R
import com.nureddinelmas.fast_coffe_android.model.Order
import kotlinx.android.synthetic.main.item_layout.view.*

class OrderAdapter(var orderList: ArrayList<Order>) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {
	
	class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
	
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
		return ViewHolder(view)
	}
	
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		
		holder.itemView.textName.text = orderList[position].name
		holder.itemView.textSize.text = orderList[position].size.toString()
		holder.itemView.textType.text = orderList[position].type.toString()
	}
	
	override fun getItemCount(): Int = orderList.size
}