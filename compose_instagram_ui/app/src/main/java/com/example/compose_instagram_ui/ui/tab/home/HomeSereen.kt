package com.example.compose_instagram_ui.ui.tab.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_instagram_ui.R
import com.example.compose_instagram_ui.dummy.storyDummy


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Instgram") },
                actions = {
                    
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier= Modifier
                            .size(30.dp)

                    ) {
                        Image(painter = painterResource(id = R.drawable.heart_icon) , contentDescription = "heaert")

                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier= Modifier
                            .size(30.dp)

                    ) {
                        Image(painter = painterResource(id = R.drawable.plane_icon) , contentDescription = "heaert")

                    }
//                    Image(painter = painterResource(id = R.drawable.heart_icon) , contentDescription = "heaert")
//                    Image(Painter = painterResource(id = R.drawable.guide_icon), contentDescription = "guide")
                }
            )
        }
    ) {
        padding->
        Column(modifier = Modifier.padding(padding)){
            StoryArea(storyDataList = storyDummy)
            FeedArea()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}