package com.example.road_traffic_app

data class Traffic(
    val trafficctprvnNm: String,
    val trafficsignguNm: String,
    var trafficitlpc : String? = "",
    var longitude : String? = "",
    var latitude : String? = ""
)