package com.example.compose_instagram_ui.ui.tab.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_instagram_ui.R
import com.example.compose_instagram_ui.dummy.StoryData
import com.example.compose_instagram_ui.dummy.storyDummy

@Composable
fun FeedItem(
    storyItem: StoryData
){
    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = storyItem.image), contentDescription = "img",
                modifier= Modifier
                    .clip(CircleShape)
                    .size(50.dp),
                contentScale = ContentScale.Crop)
//            Spacer(modifier = Modifier.size(width = 4.dp, height = 0.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = storyItem.name)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ },
                modifier=Modifier.size(20.dp)) {
                Image(painter = painterResource(id = R.drawable.menu_icon), contentDescription = "menu")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Blue))
    }
}
//            item { StoryArea(storyDataList = storyDummy) }
//            item {
//                Divider(
//                    thickness = 1.dp,
//                    color = Color.Gray.copy(alpha = 0.3f)
//                )
//            }
//            item { FeedArea(storyDataList = storyDummy) }



//                LazyRow(modifier = Modifier.fillMaxWidth()) {
//                    items(storyDummy) { storydata ->
//                        StoryItem(storyItem = storydata)
//                    }
//                }
@Preview(showBackground = true)
@Composable
fun FeedItemPreview(){
    FeedItem(storyDummy[0])
}