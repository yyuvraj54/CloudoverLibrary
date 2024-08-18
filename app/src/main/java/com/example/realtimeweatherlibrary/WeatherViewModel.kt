package com.example.realtimeweatherlibrary


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cloudover.Api.Cloudover
import com.example.realtimeweatherlibrary.Api.NetworkResponse
import com.example.cloudover.Api.Model.WeatherModel


class WeatherViewModel :ViewModel() {


    val cloudover = Cloudover("5dd3279cec964931b3e193821241808")
    val weatherResult: LiveData<NetworkResponse<WeatherModel>> = cloudover.weatherResult

    fun getData(city: String) {
        cloudover.getData(city)
    }

}