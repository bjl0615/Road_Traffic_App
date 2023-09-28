package com.example.road_traffic_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.road_traffic_app.databinding.ItemCameraBinding

class CameraListAdapter(val onClick : (CameraEntity) -> Unit) :
    ListAdapter<CameraEntity , CameraListAdapter.ViewHolder>(diffUtil) {

    inner class ViewHolder(private val viewBinding: ItemCameraBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: CameraEntity) {
            viewBinding.ctprvnNmTextView.text = item.ctprvnNm
            viewBinding.signguNmTextView.text = item.signguNm
            viewBinding.itlpcTextView.text = item.itlpc

            viewBinding.root.setOnClickListener {
                onClick(item)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  {
        return ViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CameraEntity>() {
            override fun areItemsTheSame(oldItem: CameraEntity, newItem: CameraEntity): Boolean {
                return oldItem.ctprvnNm == newItem.ctprvnNm
            }

            override fun areContentsTheSame(oldItem: CameraEntity, newItem: CameraEntity): Boolean {
                return oldItem == newItem
            }

        }
    }
}