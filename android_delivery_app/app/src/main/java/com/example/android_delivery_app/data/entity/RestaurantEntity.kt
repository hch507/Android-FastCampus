package com.example.android_delivery_app.data.entity

import android.os.Parcelable
import com.example.android_delivery_app.screen.main.home.reataurant.RestaurantCategory
import kotlinx.parcelize.Parcelize

//Todo : Parcelize??
@Parcelize
data class RestaurantEntity (
    override val id: Long,
    val restaurantInfoId: Long,
    val restaurantCategory : RestaurantCategory,
    val restaurantTitle : String,
    val restaurantImageUrl : String,
    val grade : Float,
    val reviewCount : Int,
    val deliverTimeRange: Pair<Int, Int>,
    val deliveryTipRange: Pair<Int, Int>
) : Entity,  Parcelable