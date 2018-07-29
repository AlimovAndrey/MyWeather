package com.alimov.myweather.domain.interactor

import com.alimov.myweather.BuildConfig
import com.alimov.myweather.data.repository.WeatherRepository
import com.alimov.myweather.domain.model.LocationWeather
import com.alimov.myweather.utils.ThreadHolder
import io.reactivex.Observable

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class GetWeatherInteractor(private val weatherRepository : WeatherRepository, private val threadHolder : ThreadHolder) {

    fun getLocationWeather(): Observable<LocationWeather> {
        return weatherRepository.getLocationWeather(BuildConfig.LOCATION_NAME)
                .observeOn(threadHolder.getMain())
    }
}