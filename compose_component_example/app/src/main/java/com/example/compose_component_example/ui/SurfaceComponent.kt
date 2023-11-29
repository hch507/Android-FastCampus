package com.example.compose_component_example.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SurfaceExample(){
    Surface(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = "hellow compose",
            modifier = Modifier.padding(8.dp)
        )
    }

    //elevation
    Surface(
        modifier = Modifier.padding(8.dp),
        shadowElevation = 10.dp

    ) {
        Text(
            text = "hellow compose",
            modifier = Modifier.padding(8.dp)
        )
    }
    //border
    Surface(
        modifier = Modifier.padding(8.dp),
        shadowElevation = 10.dp,
        border = BorderStroke(2.dp, Color.Blue)

    ) {
        Text(
            text = "hellow compose",
            modifier = Modifier.padding(8.dp)
        )
    }
    Surface(
        modifier = Modifier.padding(8.dp),
        shadowElevation = 10.dp,
        border = BorderStroke(2.dp, Color.Blue),
        shape = CircleShape
    ) {
        Text(
            text = "hellow compose",
            modifier = Modifier.padding(8.dp)
        )
    }
    //shape
}