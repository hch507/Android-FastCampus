package com.example.android_delivery_app.screen.main.home.reataurant

import androidx.annotation.StringRes
import com.example.android_delivery_app.R

enum class RestaurantCategory(
    @StringRes val categoryNameID : Int,
    @StringRes val categoryTypeId : Int
){

    ALL(R.string.all, R.string.all_type)
}