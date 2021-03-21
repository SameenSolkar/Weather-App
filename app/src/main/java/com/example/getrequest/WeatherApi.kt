package com.example.getrequest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import kotlin.collections.HashMap

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeatherData(@Query("q") q:String,
                               @Query("appid")appid:String,
                               @Query("units")unit:String):Response<Weather>

    //suspend fun getWeatherData(@Query("postId")postId:Int):Response<List<Comments>>
}