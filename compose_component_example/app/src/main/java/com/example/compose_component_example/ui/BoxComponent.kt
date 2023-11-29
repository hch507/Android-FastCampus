package com.example.compose_component_example.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BoxExample(){
    //box는 box자체를 만들거나 famelayout처럼 중첩이 필요할떄 사용
    Box(
        modifier = Modifier.size(100.dp)
    ) {
        Text("hello", modifier = Modifier.align(Alignment.Center))
        Text("compose", modifier = Modifier.align(Alignment.TopStart))
    }
}