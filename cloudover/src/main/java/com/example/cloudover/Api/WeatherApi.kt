package com.example.realtimeweatherlibrary.Api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface WeatherApi {


    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apikey : String,
        @Query("q") city : String
    ) : Response<WeatherModel>

}