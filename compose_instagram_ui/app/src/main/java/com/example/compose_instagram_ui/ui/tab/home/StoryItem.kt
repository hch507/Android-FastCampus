package com.example.compose_instagram_ui.ui.tab.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_instagram_ui.dummy.StoryData
import com.example.compose_instagram_ui.dummy.storyDummy

@Composable
fun StoryItem(
    storyItem: StoryData
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)

    ) {
        Image(
            painter = painterResource(id = storyItem.image),
            contentDescription = "Img",
            contentScale = ContentScale.Crop,
            modifier= Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Black, CircleShape)
                .size(80.dp),
                )
        Text(text = storyItem.name)
    }
}

@Preview(showBackground = true)
@Composable
fun StoryItemPreview() {
    StoryItem(storyDummy[3])
}