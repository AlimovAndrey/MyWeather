package com.alimov.myweather.utils

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class ThreadHolder @Inject constructor() {

    private val NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors()
    private val KEEP_ALIVE_TIME = 300

    private var generalExecutor: ThreadPoolExecutor
    private var restExecutor: ThreadPoolExecutor

    init {
        val generalWorkQueue = LinkedBlockingQueue<Runnable>()
        generalExecutor = ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES,
                KEEP_ALIVE_TIME.toLong(),
                TimeUnit.SECONDS,
                generalWorkQueue)

        val restWorkQueue = LinkedBlockingQueue<Runnable>()
        restExecutor = ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES,
                KEEP_ALIVE_TIME.toLong(),
                TimeUnit.SECONDS,
                restWorkQueue)

    }

    fun getGeneral(): Scheduler {
        return Schedulers.from(generalExecutor)
    }

    fun getRest(): Scheduler {
        return Schedulers.from(restExecutor)
    }

    fun getMain(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}