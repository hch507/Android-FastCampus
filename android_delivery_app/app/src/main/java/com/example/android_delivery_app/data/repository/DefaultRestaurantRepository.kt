package com.example.android_delivery_app.data.repository

import com.example.android_delivery_app.data.entity.RestaurantEntity
import com.example.android_delivery_app.screen.main.home.reataurant.RestaurantCategory
import com.example.android_delivery_app.utils.provider.ResourceProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultRestaurantRepository(
    private val resourceProvider: ResourceProvider,
    private val isDispatcher : CoroutineDispatcher
) : RestaurantRepository {
    override suspend fun getList(retaurantCategory: RestaurantCategory): List<RestaurantEntity> = withContext(isDispatcher) {
        //Todo : api 리넡 바당요기
        return@withContext listOf(
            RestaurantEntity(
                id = 0,
                restaurantCategory = RestaurantCategory.ALL,
                restaurantTitle = "마포화로집",
                restaurantImageUrl = "https//picsum.photos/200",
                grade = 100.0f,
                reviewCount = 30,
                deliverTimeRange = Pair(0,20),
                deliveryTipRange = Pair(0,2000),
                restaurantInfoId = 1
            ),
            RestaurantEntity(
                id = 1,
                restaurantCategory = RestaurantCategory.ALL,
                restaurantTitle = "마포화로집",
                restaurantImageUrl = "https//picsum.photos/200",
                grade = 100.0f,
                reviewCount = 30,
                deliverTimeRange = Pair(0,20),
                deliveryTipRange = Pair(0,2000),
                restaurantInfoId = 2
            ),
            RestaurantEntity(
                id = 2,
                restaurantCategory = RestaurantCategory.ALL,
                restaurantTitle = "마포화로집",
                restaurantImageUrl = "https//picsum.photos/200",
                grade = 100.0f,
                reviewCount = 30,
                deliverTimeRange = Pair(0,20),
                deliveryTipRange = Pair(0,2000),
                restaurantInfoId = 3
            ),
            RestaurantEntity(
                id = 3,
                restaurantCategory = RestaurantCategory.ALL,
                restaurantTitle = "마포화로집",
                restaurantImageUrl = "https//picsum.photos/200",
                grade = 100.0f,
                reviewCount = 30,
                deliverTimeRange = Pair(0,20),
                deliveryTipRange = Pair(0,2000),
                restaurantInfoId = 4
            ),
            RestaurantEntity(
                id = 4,
                restaurantCategory = RestaurantCategory.ALL,
                restaurantTitle = "마포화로집",
                restaurantImageUrl = "https//picsum.photos/200",
                grade = 100.0f,
                reviewCount = 30,
                deliverTimeRange = Pair(0,20),
                deliveryTipRange = Pair(0,2000),
                restaurantInfoId = 5
            )

        )

    }
}