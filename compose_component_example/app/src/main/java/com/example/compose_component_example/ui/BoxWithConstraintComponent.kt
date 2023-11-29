package com.example.compose_component_example.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun outer(){
    Column {
        inner(Modifier
            .widthIn(100.dp, 350.dp)
            .heightIn(100.dp , 350.dp)
        )
    }
}

@Composable
private fun inner(modifier: Modifier =Modifier){
    BoxWithConstraints(modifier) {
        Text("maxW :${maxWidth} maxH${maxHeight}: minW${minWidth}: minH:${minHeight}")
    }
}