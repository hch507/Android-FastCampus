package com.example.compose_component_example.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BoxExample(){
    //box는 box자체를 만들거나 famelayout처럼 중첩이 필요할떄 사용
    Box(
        modifier = Modifier.size(100.dp)
    ) {

    }
}