package com.metoly.weather.repository

import com.metoly.weather.models.BaseModel
import com.metoly.weather.models.DailyForecasts
import com.metoly.weather.models.HourlyForecast
import com.metoly.weather.models.Location
import com.metoly.weather.network.Api
import retrofit2.Response

class WeatherRepoImpl(private val api: Api):WeatherRepo {
    override suspend fun searchLocation(query: String): BaseModel<List<Location>> {
        return request {
            api.searchLocation(query = query)
        }
    }

    override suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts> {
        return request {
            api.getDailyForecasts(locationKey = locationKey)
        }
    }

    override suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>> {
        return request {
            api.getHourlyForecasts(locationKey = locationKey)
        }
    }
}

suspend fun <T> request(request: suspend () -> Response<T>): BaseModel<T> {
    try {
        val response = request()
        return if (response.isSuccessful) {
            BaseModel.Success(response.body()!!)
        } else {
            val errorBody = response.errorBody()?.string()
            val errorCode = response.code()
            BaseModel.Error("Error code: $errorCode, Error body: $errorBody")
        }
    } catch (e: Exception) {
        return BaseModel.Error(e.message.toString())
    }
}