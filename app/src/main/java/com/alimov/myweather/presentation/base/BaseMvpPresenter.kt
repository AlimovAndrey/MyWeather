package com.alimov.myweather.presentation.base

import com.alimov.myweather.app.App
import com.alimov.myweather.di.component.AppComponent
import com.alimov.myweather.utils.RxUtils
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
open class BaseMvpPresenter<View : MvpView>() : MvpPresenter<View>() {

    private var disposables: CompositeDisposable? = null

    init {
        disposables = RxUtils.getNewDisposableIfDisposed(disposables)
    }

    protected fun addToDisposables(disposable: Disposable) {
        if (disposables != null && !disposables!!.isDisposed) {
            disposables!!.add(disposable)
        } else {
            RxUtils.disposeIfNotNull(disposable)
        }
    }

    protected fun getAppComponent(): AppComponent {
        val app = App.get()
        return app.getAppComponent()
    }

    override fun onDestroy() {
        RxUtils.disposeIfNotNull(disposables)
        super.onDestroy()
    }
}