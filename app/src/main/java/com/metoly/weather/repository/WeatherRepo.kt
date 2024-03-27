package com.metoly.weather.repository

import com.metoly.weather.models.BaseModel
import com.metoly.weather.models.DailyForecasts
import com.metoly.weather.models.HourlyForecast
import com.metoly.weather.models.Location

interface WeatherRepo {
    suspend fun searchLocation(query:String): BaseModel<List<Location>>
    suspend fun getDailyForecasts(locationKey:String):BaseModel<DailyForecasts>
    suspend fun getHourlyForecasts(locationKey: String):BaseModel<List<HourlyForecast>>
}