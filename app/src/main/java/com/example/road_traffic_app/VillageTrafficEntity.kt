package com.example.road_traffic_app

import com.google.gson.annotations.SerializedName

data class TrafficEntity(
    @SerializedName("response")
    val response: TrafficResponse
)

data class TrafficResponse(
    @SerializedName("header")
    val header: TrafficHeader,
    @SerializedName("body")
    val body: TrafficBody
)

data class TrafficHeader(
    @SerializedName("resultCode")
    val resultCode: String,
    @SerializedName("resultMsg")
    val resultMessage: String
)

data class TrafficBody(
    @SerializedName("items")
    val CameraEntityList: List<CameraEntity>
)

data class CameraEntity(
//    무인교통단속카메라관리번호
//    @SerializedName("mnlssRegltCameraManageNo")
//    val mnlssRegltCameraManageNo : String,

    // 시도명
    @SerializedName("ctprvnNm")
    val ctprvnNm: String,

    // 시군구명
    @SerializedName("signguNm")
    val signguNm: String,

    // 도로종류
//    @SerializedName("roadKnd")
//    val roadKnd : String,

    // 도로노선번호
//    @SerializedName("roadRouteNo")
//    val roadRouteNo : String,

    // 도로노선명
//    @SerializedName("roadRouteNm")
//    val roadRouteNm : String,

    // 도로노선방향
//    @SerializedName("roadRouteDrc")
//    val roadRouteDrc : String,

    // 소재지도로명주소
//    @SerializedName("rdnmadr")
//    val rdnmadr : String,

    // 소재지지번주소
//    @SerializedName("lnmadr")
//    val lnmadr : String,

    // 위도
    @SerializedName("latitude")
    val latitude : String,

    // 경도
    @SerializedName("longitude")
    val longitude : String,

    // 설치장소
    @SerializedName("itlpc")
    val itlpc: String,

    // 단속구분
//    @SerializedName("regltSe")
//    val regltSe : String,

    // 제한속도
//    @SerializedName("lmttVe")
//    val lmttVe : String,

    // 단속구간위치구분
//    @SerializedName("regltSctnLcSe")
//    val regltSctnLcSe : String,

    // 과속단속구간길이
//    @SerializedName("ovrspdRegltSctnLt")
//    val ovrspdRegltSctnLt : String,

    // 보호구역구분
//    @SerializedName("prtcareaType")
//    val prtcareaType : String,

    // 설치년도
//    @SerializedName("installationYear")
//    val installationYear : String,

   // 관리기관명
//    @SerializedName("institutionNm")
//    val institutionNm : String,

    // 관리기관전화번호
//    @SerializedName("phoneNumber")
//    val phoneNumber : String,

   // 데이터기준일자
//    @SerializedName("referenceDate")
//    val referenceDate : String,

    // 제공기관코드
//    @SerializedName("insttCode")
//    val insttCode : String
)