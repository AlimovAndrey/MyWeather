package com.alimov.myweather.data.repository

import com.alimov.myweather.domain.model.LocationWeather
import com.alimov.myweather.domain.repository.IWeatherRepository
import com.alimov.myweather.rest.api.WeatherApiServiceImp
import io.reactivex.Observable


/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

open class WeatherRepository(private val weatherApiServiceImp: WeatherApiServiceImp) : IWeatherRepository {

    override fun getLocationWeather(locationName: String): Observable<LocationWeather> {
        //can be save to cache
        return weatherApiServiceImp.getLocationWeather(locationName)
    }
}