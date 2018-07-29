package com.alimov.myweather.di.module

import com.alimov.myweather.data.repository.WeatherRepository
import com.alimov.myweather.domain.interactor.GetWeatherInteractor
import com.alimov.myweather.utils.ThreadHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

@Module
class UseCaseModule {

    @Provides
    @Singleton
    internal fun provideGetWeatherInteractor(weatherRepository: WeatherRepository, threadHolder: ThreadHolder): GetWeatherInteractor {
        return GetWeatherInteractor(weatherRepository, threadHolder)
    }
}