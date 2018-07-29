package com.alimov.myweather.ui

import android.os.Bundle
import android.widget.Toast
import com.alimov.myweather.R
import com.alimov.myweather.presentation.location.LocationWeatherPresenter
import com.alimov.myweather.presentation.location.LocationWeatherView
import com.alimov.myweather.presentation.location.model.LocationWeatherViewModel
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), LocationWeatherView {

    @InjectPresenter
    lateinit var presenter: LocationWeatherPresenter

    @ProvidePresenter
    fun provideLocationWeatherPresenter() = LocationWeatherPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showLocationWeather(viewModel: LocationWeatherViewModel) {
        locationNameView.text = viewModel.name
        locationTemperatureView.text = getString(R.string.location_temperature, viewModel.temperature)
        locationHumidityView.text = getString(R.string.location_humidity, viewModel.humidity)
        locationWindView.text = getString(R.string.location_wind, viewModel.wind)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
