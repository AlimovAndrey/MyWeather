package com.alimov.myweather.domain.repository

import com.alimov.myweather.domain.model.LocationWeather
import io.reactivex.Observable

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
interface IWeatherRepository {
    fun getLocationWeather(locationName : String) : Observable<LocationWeather>
}