package com.alimov.myweather.di.component

import com.alimov.myweather.di.module.AppModule
import com.alimov.myweather.di.module.DataModule
import com.alimov.myweather.di.module.RestClientModule
import com.alimov.myweather.di.module.UseCaseModule
import com.alimov.myweather.presentation.location.LocationWeatherPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

@Singleton
@Component(modules = [
    (AppModule::class),
    (RestClientModule::class),
    (DataModule::class),
    (UseCaseModule::class)
    ])
interface AppComponent {

    fun inject(locationWeatherPresenter: LocationWeatherPresenter)
}