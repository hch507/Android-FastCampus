package com.example.compose_component_example.ui

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun textExample(text: String) {

    Text("hello $text")

    //컬러
    Text(color = Color.Blue, text = "hello $text")

    //폰트 사이즈
    Text(color = Color.Blue, text = "hello $text", fontSize = 30.sp)

    //폰트
    Text(color = Color.Blue, text = "hello $text", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    //폰트 패밀리
    Text(
        color = Color.Blue,
        text = "hello $text",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive)
    //letterspace
    Text(
        color = Color.Blue,
        text = "hello $text",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp)

    //maxline
    Text(
        color = Color.Blue,
        text = "hello $text",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2)

    //text decoration
    Text(
        color = Color.Blue,
        text = "hello $text",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline)

    //text 정렬
    Text(
        modifier = Modifier.size(200.dp),
        color = Color.Blue,
        text = "hello $text",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Cursive,
        letterSpacing = 2.sp,
        maxLines = 2,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center)




}
