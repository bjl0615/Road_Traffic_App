package com.example.road_traffic_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TrafficService {

    @GET("openapi/tn_pubr_public_unmanned_traffic_camera_api?serviceKey=GHtOs1th4Ary54FRBL%2BIlvgHA9%2B8KzKmtP4IeL%2B7xedYs826AfImmN78Ze4%2FWZJEuYULzEJsVtNBXGXY2OOO2g%3D%3D&pageNo=1&numOfRows=100&type=json")
    fun getVillageTraffic(
        @Query("ctprvnNm") ctprvnNm : String,
        @Query("signguNm") signguNm : String
    ) : Call<TrafficEntity>

}