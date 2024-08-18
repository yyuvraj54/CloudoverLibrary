package com.example.cloudover.Api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.realtimeweatherlibrary.Api.NetworkResponse
import com.example.realtimeweatherlibrary.Api.RetrofitInstance
import com.example.realtimeweatherlibrary.Api.WeatherModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class Cloudover(val apiKey: String) : CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult: LiveData<NetworkResponse<WeatherModel>> = _weatherResult

    fun getData(city: String) {
        _weatherResult.value = NetworkResponse.Loading
        launch(Dispatchers.IO) {
            try {
                val response = weatherApi.getWeather(apiKey, city)
                if (response.isSuccessful) {
                    Log.d("Cloudover","Response Success")
                    response.body()?.let {
                        _weatherResult.postValue(NetworkResponse.Success(it))
                    }
                } else {
                    Log.d("Cloudover","Failed to load data")
                    _weatherResult.postValue(NetworkResponse.Error("Failed to load data"))
                }
            } catch (e: Exception) {
                Log.d("Cloudover","Failed to load data")
                _weatherResult.postValue(NetworkResponse.Error("Failed to load data"))
            }
        }
    }

    fun cancel() {
        job.cancel()
    }
}
