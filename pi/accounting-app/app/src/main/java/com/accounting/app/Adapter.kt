package com.accounting.app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var dataSet : List<CustomersEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customers, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dataSet.get(position).name
        holder.doc.text = dataSet.get(position).doc
        holder.description.text = dataSet.get(position).description
        holder.date.text = dataSet.get(position).joinedAt
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.c_name)
        val doc = itemView.findViewById<TextView>(R.id.c_doc)
        val description = itemView.findViewById<TextView>(R.id.c_description)
        val date = itemView.findViewById<TextView>(R.id.c_date)
    }

    fun setData(newData : List<CustomersEntity>) {
        dataSet = newData
        notifyDataSetChanged()
    }

    fun getData(position: Int) : CustomersEntity {
        return dataSet.get(position)
    }
}
