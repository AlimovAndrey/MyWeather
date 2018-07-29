package com.alimov.myweather.rest.api

import com.alimov.myweather.domain.model.LocationWeather
import com.alimov.myweather.rest.utils.RestConstant
import io.reactivex.Observable

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class WeatherApiServiceImp (private val weatherApiService: WeatherApiService) {

    fun getLocationWeather(locationName: String): Observable<LocationWeather> {
        val data = getLocationMap(locationName)
        return weatherApiService.getLocationWeather(data)
    }

    private fun getLocationMap(locationName : String) : MutableMap<String, String> {
        val data = mutableMapOf<String, String>()
        data["q"] = locationName
        data["appid"] = RestConstant.APP_KEY
        return data
    }

}