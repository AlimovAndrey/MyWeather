package com.alimov.myweather.di.qualifier

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Qualifier

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */

@Qualifier
@Retention(RUNTIME)
annotation class AppContext {
}