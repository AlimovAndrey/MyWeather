package com.alimov.myweather.presentation.mapper

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
interface Mapper<out V, in D> {

    fun mapToView(type: D): V
}