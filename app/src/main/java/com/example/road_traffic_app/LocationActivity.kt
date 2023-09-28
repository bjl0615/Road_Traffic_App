package com.example.road_traffic_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.road_traffic_app.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLocationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val longitude = intent.getStringExtra("longitude") ?: return
        val latitude = intent.getStringExtra("latitude") ?: return

        binding.lat.text = latitude
        binding.longit.text = longitude
    }
}