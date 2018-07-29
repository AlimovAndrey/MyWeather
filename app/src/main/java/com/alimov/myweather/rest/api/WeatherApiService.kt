package com.alimov.myweather.rest.api

import com.alimov.myweather.domain.model.LocationWeather
import com.alimov.myweather.rest.utils.RestConstant
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
interface WeatherApiService {

    @GET(RestConstant.API_LOCATION_WEATHER_PATH)
    fun getLocationWeather(
            @QueryMap(encoded = true) mutableMap: MutableMap<String, String>
    ): Observable<LocationWeather>
}