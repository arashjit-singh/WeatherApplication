package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.domain.util.Resource
import com.example.weatherapplication.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}