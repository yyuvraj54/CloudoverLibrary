package com.example.realtimeweatherlibrary


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cloudover.Api.Cloudover
import com.example.realtimeweatherlibrary.Api.Constant
import com.example.realtimeweatherlibrary.Api.NetworkResponse
import com.example.realtimeweatherlibrary.Api.RetrofitInstance
import com.example.realtimeweatherlibrary.Api.WeatherModel
import kotlinx.coroutines.launch


class WeatherViewModel :ViewModel() {


    val cloudover = Cloudover("5dd3279cec964931b3e193821241808")
    val weatherResult: LiveData<NetworkResponse<WeatherModel>> = cloudover.weatherResult

    fun getData(city: String) {
        cloudover.getData(city)
    }

}