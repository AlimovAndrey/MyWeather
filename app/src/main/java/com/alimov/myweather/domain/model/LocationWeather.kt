package com.alimov.myweather.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Alimov Andrey
 * on 28.07.2018.
 */
class LocationWeather {

    @SerializedName("name")
    var name : String? = null

    @SerializedName("main")
    var params : Params? = null

    @SerializedName("wind")
    var wind : Wind? = null

    inner class Params {

        @SerializedName("temp")
        var temp : Float? = null

        @SerializedName("humidity")
        var humidity : Int? = null
    }

    inner class Wind {

        @SerializedName("speed")
        var speed : Int? = null
    }
}