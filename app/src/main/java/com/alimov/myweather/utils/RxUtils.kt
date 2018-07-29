package com.alimov.myweather.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class RxUtils {

    companion object {
        fun getNewDisposableIfDisposed(compositeDisposable: CompositeDisposable?): CompositeDisposable {
            return if (compositeDisposable == null || compositeDisposable.isDisposed) {
                CompositeDisposable()
            } else compositeDisposable
        }

        fun disposeIfNotNull(disposable: Disposable?) {
            if (disposable != null && !disposable.isDisposed) {
                disposable.dispose()
            }
        }
    }
}