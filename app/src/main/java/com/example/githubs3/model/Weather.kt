package com.example.com.example..model

data class Weather(
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime: String
)

data class Current(
    val last_updated: String,
    val last_updated_epoch: Int,
    val temp_c: Double,
    val temp_f: Double,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val windchill_c: Double,
    val windchill_f: Double,
    val heatindex_c: Double,
    val heatindex_f: Double,
    val dewpoint_c: Double,
    val dewpoint_f: Double,
    val condition: Condition,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Double,
    val pressure_in: Double,
    val precip_mm: Double,
    val precip_in: Double,
    val humidity: Int,
    val cloud: Int,
    val is_day: Int,
    val uv: Double,
    val gust_mph: Double,
    val gust_kph: Double
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)
