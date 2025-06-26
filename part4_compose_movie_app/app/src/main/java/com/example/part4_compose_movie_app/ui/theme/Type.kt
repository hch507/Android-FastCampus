package com.example.part4_compose_movie_app.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontSize = 60.sp
    ),
    h2 =  TextStyle(
        fontSize = 32.sp
    ),
    h3 =  TextStyle(
        fontSize = 24.sp
    ),
    button = TextStyle(
        fontSize = 18.sp
    ),
    subtitle1 = TextStyle(
        fontSize = 18.sp
    ),
    subtitle2 = TextStyle(
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontSize = 15.sp
    ),
    body2 = TextStyle(
        fontSize = 14.sp
    )
)

val Typography.h3Title :TextStyle
    @Composable get() = h3.copy(
        fontSize = 26.sp
    )