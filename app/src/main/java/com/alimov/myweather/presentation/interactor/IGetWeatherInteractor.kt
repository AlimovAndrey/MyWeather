package com.alimov.myweather.presentation.interactor

import com.alimov.myweather.domain.model.LocationWeather
import io.reactivex.Single

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
interface IGetWeatherInteractor {

    fun getLocationWeather(): Single<LocationWeather>
}