package com.complaints.app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var dataSet : List<ComplaintsEntity> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.complaints, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.code.text = dataSet.get(position).code
        holder.description.text = dataSet.get(position).description
        holder.date.text = dataSet.get(position).date
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val code = itemView.findViewById<TextView>(R.id.c_code)
        val description = itemView.findViewById<TextView>(R.id.c_description)
        val date = itemView.findViewById<TextView>(R.id.c_date)
    }

    fun setData(newData : List<ComplaintsEntity>) {
        dataSet = newData
        notifyDataSetChanged()
    }

    fun getData(position: Int) : ComplaintsEntity {
        return dataSet.get(position)
    }
}
