package com.alimov.myweather.presentation.mapper

import com.alimov.myweather.domain.model.LocationWeather
import com.alimov.myweather.presentation.location.model.LocationWeatherViewModel
import com.alimov.myweather.utils.TemperatureUtils

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class LocationWeatherMapper : Mapper<LocationWeatherViewModel, LocationWeather> {

    override fun mapToView(type: LocationWeather): LocationWeatherViewModel {
        return LocationWeatherViewModel(
                type.name!!,
                TemperatureUtils.toC(type.params?.temp!!),
                type.params?.humidity!!,
                type.wind?.speed!!
        )
    }
}