package com.alimov.myweather.utils

/**
 * Created by Alimov Andrey
 * on 29.07.2018.
 */
class TemperatureUtils {

    companion object {
        fun toC(f : Float) : Int {
            return (f - 273.15).toInt()
        }
    }
}