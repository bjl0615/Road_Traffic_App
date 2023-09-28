package com.example.road_traffic_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.road_traffic_app.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var cameraadapter : CameraListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.data.go.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(TrafficService::class.java)

        binding.applyButton.setOnClickListener {
            val ctprvnNm = binding.usernameEditText.text.toString()
            val signguNm = binding.descriptionEditText.text.toString()

            service.getVillageTraffic(
                ctprvnNm = ctprvnNm,
                signguNm = signguNm
            ).enqueue(object : Callback<TrafficEntity>{
                override fun onResponse(call: Call<TrafficEntity>, response: Response<TrafficEntity>) {
                    val cameraLocationMap = mutableMapOf<String , Traffic>()
                    val cameraList = response.body()?.response?.body?.CameraEntityList
                    val datas = mutableListOf<CameraEntity>()
                    if(cameraList == null) {
                        Toast.makeText(this@MainActivity , "잘못입력하셨습니다." , Toast.LENGTH_SHORT).show()
                    }else {
                        for (camera in cameraList) {
                            if (cameraLocationMap["${camera.ctprvnNm}/${camera.signguNm}"] == null) {
                                cameraLocationMap["${camera.ctprvnNm}/${camera.signguNm}"] =
                                    Traffic(
                                        trafficctprvnNm = camera.ctprvnNm,
                                        trafficsignguNm = camera.signguNm
                                    )
                            }
                            cameraLocationMap["${camera.ctprvnNm}/${camera.signguNm}"]?.apply {
                                trafficitlpc = camera.itlpc
                                longitude = camera.longitude
                                latitude = camera.latitude
                            }

                            datas.apply {
                                add(camera)
                            }
                        }
                        cameraadapter = CameraListAdapter {
                            val intent = Intent(this@MainActivity , LocationActivity::class.java)
                            intent.putExtra("longitude" , it.longitude)
                            intent.putExtra("latitude" , it.latitude)
                            startActivity(intent)
                        }

                        val linearLayoutManager = LinearLayoutManager(this@MainActivity)

                        binding.CameraList.apply {
                            layoutManager = linearLayoutManager
                            adapter = cameraadapter
                        }

                        cameraadapter.submitList(cameraList)
                    }
                }
                override fun onFailure(call: Call<TrafficEntity>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }


    }



}