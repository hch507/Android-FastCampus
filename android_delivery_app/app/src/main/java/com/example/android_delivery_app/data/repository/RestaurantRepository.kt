package com.example.android_delivery_app.data.repository

import com.example.android_delivery_app.data.entity.RestaurantEntity
import com.example.android_delivery_app.screen.main.home.reataurant.RestaurantCategory

interface RestaurantRepository {
    suspend fun getList(
        retaurantCategory: RestaurantCategory,
    ) : List<RestaurantEntity>
}