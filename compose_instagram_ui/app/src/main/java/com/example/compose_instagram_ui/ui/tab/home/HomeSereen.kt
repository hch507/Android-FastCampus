package com.example.compose_instagram_ui.ui.tab.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_instagram_ui.R
import com.example.compose_instagram_ui.dummy.storyDummy


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Instgram") },
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(30.dp)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.heart_icon),
                            contentDescription = "heaert"
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .size(30.dp)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.plane_icon),
                            contentDescription = "heaert"
                        )

                    }
//                    Image(painter = painterResource(id = R.drawable.heart_icon) , contentDescription = "heaert")
//                    Image(Painter = painterResource(id = R.drawable.guide_icon), contentDescription = "guide")
                }
            )
        }
    ) {
        it
        val scrollState = rememberScrollState()
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),

        ) {
            item(){
                LazyRow(modifier = Modifier.wrapContentSize()) {
                    items(storyDummy){ storydata->
                        StoryItem(storyItem = storydata)
                    }
                }
            }
            stickyHeader {
                Divider(
                    thickness = 1.dp,
                    color = Color.Gray.copy(alpha = 0.3f)
                )
            }
            items(storyDummy) { StoryData ->
                FeedItem(storyItem = StoryData)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}