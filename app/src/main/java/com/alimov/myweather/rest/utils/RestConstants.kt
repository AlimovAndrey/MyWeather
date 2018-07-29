package com.alimov.myweather.rest.utils

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class RestConstant {

    companion object {
        const val REST_TIMEOUT_IN_SECONDS: Long = 30
        const val SERVER_URL: String = "https://api.openweathermap.org/data/2.5/"
        const val APP_KEY: String = "092bd233a16f033f2e032a0defb77faf"

        const val API_LOCATION_WEATHER_PATH = "/data/2.5/weather"
    }

}