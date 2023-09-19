package com.example.road_traffic_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CameraListAdapter(private val context: Context) :
    RecyclerView.Adapter<CameraListAdapter.ViewHolder>() {

    var datast = mutableListOf<CameraEntity>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val trafficctprvnNm : TextView = itemView.findViewById(R.id.ctprvnNmTextView)
        private val trafficsignguNm : TextView = itemView.findViewById(R.id.signguNmTextView)
        private val trafficitlpc : TextView = itemView.findViewById(R.id.itlpcTextView)

        fun bind(item: CameraEntity) {
            trafficctprvnNm.text = item.ctprvnNm
            trafficsignguNm.text = item.signguNm
            trafficitlpc.text = item.itlpc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_camera,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datast[position])
    }
}