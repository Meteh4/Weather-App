package com.metoly.weather.models

import com.google.gson.annotations.SerializedName

data class DailyForecast(
    @SerializedName("Date")
    val date: String,
    @SerializedName("EpochDate")
    val epochDate: Long,
    @SerializedName("Temperature")
    val temperature: Temperature,
    @SerializedName("Day")
    val day: WeatherStat,
    @SerializedName("Night")
    val night: WeatherStat
)

data class Temperature(
    @SerializedName("Minimum")
    val minimum: Value,
    @SerializedName("Maximum")
    val maximum: Value
) {
    data class Value(
        @SerializedName("Value")
        val value: Double,
        @SerializedName("Unit")
        val unit: String,
        @SerializedName("UnitType")
        val unitType: Int
    )
}

data class WeatherStat(
    @SerializedName("Icon")
    val icon: Int,
    @SerializedName("IconPhrase")
    val iconPhrase: String,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean
)