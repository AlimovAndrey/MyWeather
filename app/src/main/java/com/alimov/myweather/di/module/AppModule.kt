package com.alimov.myweather.di.module

import android.content.Context
import com.alimov.myweather.app.App
import com.alimov.myweather.di.qualifier.AppContext
import com.alimov.myweather.presentation.mapper.LocationWeatherMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

@Module
class AppModule(private var app: App) {

    @Provides
    internal fun provideApp(): App {
        return app
    }

    @Provides
    @Singleton
    @AppContext
    internal fun provideContext(app: App): Context {
        return app
    }

    @Provides
    @Singleton

    internal fun provideMapper(): LocationWeatherMapper {
        return LocationWeatherMapper()
    }
}