package com.example.compose_instagram_ui.ui.tab.home

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_instagram_ui.dummy.StoryData
import com.example.compose_instagram_ui.dummy.storyDummy

@Composable
fun StoryArea(
    storyDataList : List<StoryData>
){
    LazyRow(modifier = Modifier.wrapContentSize()) {
        items(storyDataList){storydata->
            StoryItem(storyItem = storydata)
        }
    }
     
}

@Preview(showBackground = true)
@Composable
fun StoryAreaPreview(){
    StoryArea(storyDataList = storyDummy)
}