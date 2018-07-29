package com.alimov.myweather.presentation.location

import com.alimov.myweather.presentation.location.model.LocationWeatherViewModel
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */


@StateStrategyType(AddToEndStrategy::class)
interface LocationWeatherView : MvpView {

    fun showLocationWeather(viewModel : LocationWeatherViewModel)
    fun showError(message : String)
}