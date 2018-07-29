package com.alimov.myweather.app

import android.app.Application
import com.alimov.myweather.di.component.AppComponent
import com.alimov.myweather.di.component.DaggerAppComponent
import com.alimov.myweather.di.module.AppModule

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class App : Application() {

    private lateinit var appComponent: AppComponent

    companion object {

        private lateinit var instance: App

        fun init(app : App) {
            instance = app
        }

        fun get(): App {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        init(this)
        initComponent(this)
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

    private fun initComponent(app: App) {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .build()
    }
}