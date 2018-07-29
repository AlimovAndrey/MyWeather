package com.alimov.myweather.di.module

import com.alimov.myweather.BuildConfig
import com.alimov.myweather.rest.api.WeatherApiService
import com.alimov.myweather.rest.api.WeatherApiServiceImp
import com.alimov.myweather.rest.utils.RestConstant
import com.alimov.myweather.utils.ThreadHolder
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

@Module
class RestClientModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return loggingInterceptor
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(RestConstant.REST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        httpClient.connectTimeout(RestConstant.REST_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        httpClient.addInterceptor(loggingInterceptor)
        return httpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson, threadHolder: ThreadHolder): Retrofit {
        val adapterFactory = RxJava2CallAdapterFactory
                .createWithScheduler(threadHolder.getRest())
        val converterFactory = GsonConverterFactory.create(gson)

        return Retrofit.Builder()
                .baseUrl(RestConstant.SERVER_URL)
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideWeatherApiService(retrofit: Retrofit) : WeatherApiService {
        return retrofit.create<WeatherApiService>(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideWeatherApiServiceImp(weatherApiService: WeatherApiService): WeatherApiServiceImp {
        return WeatherApiServiceImp(weatherApiService)
    }
}