package com.alimov.myweather.presentation.location

import com.alimov.myweather.domain.interactor.GetWeatherInteractor
import com.alimov.myweather.presentation.base.BaseMvpPresenter
import com.alimov.myweather.presentation.mapper.LocationWeatherMapper
import com.alimov.myweather.utils.Constants
import com.arellomobile.mvp.InjectViewState
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

@InjectViewState
class LocationWeatherPresenter : BaseMvpPresenter<LocationWeatherView>() {

    @Inject
    lateinit var weatherInteractor: GetWeatherInteractor

    @Inject
    lateinit var mapper: LocationWeatherMapper

    private lateinit var disposable: Disposable

    init {
        getAppComponent().inject(this)
        getWeather()
    }

    private fun getWeather() {
        disposable = weatherInteractor.getLocationWeather()
                .repeatWhen { result -> result.delay(Constants.UPDATE_FREQUENCY, TimeUnit.SECONDS) }
                .subscribe(
                        { locationWeather ->
                            viewState.showLocationWeather(mapper.mapToView(locationWeather))
                        },
                        { error -> viewState.showError(error.message!!) }
                )
        addToDisposables(disposable)
    }

}