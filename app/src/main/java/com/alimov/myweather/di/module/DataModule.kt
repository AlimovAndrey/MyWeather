package com.alimov.myweather.di.module

import com.alimov.myweather.data.repository.WeatherRepository
import com.alimov.myweather.rest.api.WeatherApiService
import com.alimov.myweather.rest.api.WeatherApiServiceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

@Module
class DataModule {

    @Provides
    @Singleton
    internal fun provideWeatherRepository(weatherApiServiceImp: WeatherApiServiceImp): WeatherRepository {
        return WeatherRepository(weatherApiServiceImp)
    }
}