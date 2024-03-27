package com.metoly.weather.network
import com.metoly.weather.models.DailyForecasts
import com.metoly.weather.models.HourlyForecast
import com.metoly.weather.models.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val APIKEY = "W0FpTxDkDYbnWM358AGO2yaAGAYR0Sxm\n"

interface Api {
    @GET("locations/v1/cities/search")
    suspend fun searchLocation(
        @Query("apikey") apiKey: String = APIKEY,
        @Query("q") query: String
    ): Response<List<Location>>

    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = true
    ): Response<DailyForecasts>

    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = true
    ):Response<List<HourlyForecast>>
}