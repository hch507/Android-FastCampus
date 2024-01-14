package com.example.compose_instagram_ui.dummy

import com.example.compose_instagram_ui.R

data class StoryData(
    val image : Int,
    val name : String
)


val storyDummy : List<StoryData> = listOf(
    StoryData(image = R.drawable.top_user_img, name = "name1"),
    StoryData(image = R.drawable.top_user2_img, name = "name2"),
    StoryData(image = R.drawable.top_user3_img, name = "name3"),
    StoryData(image = R.drawable.top_user4_img, name = "name4"),
    StoryData(image = R.drawable.top_user8_img, name = "name5"),
    StoryData(image = R.drawable.top_user6_img, name = "name6"),
    StoryData(image = R.drawable.top_user7_img, name = "name7"),

)
