package com.example.compose_component_example.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun buttonExample(onButton:()->Unit){
    Button(onClick = onButton) {
        Text("button")
    }
    //클릭시 토스트 버튼

    //icon 넣기
    Button(onClick = onButton) {
        Icon(imageVector =Icons.Filled.Send, contentDescription = null)
        Text("button")
    }
    //아이콘과 텍스트 사이에 여백넣기
    Button(onClick = onButton) {
        Icon(imageVector =Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

    //enable
    Button(
        onClick = onButton,
        enabled = false
    ) {
        Icon(imageVector =Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }
    //borderStroke

    Button(
        onClick = onButton,
        enabled = false,
        border = BorderStroke(10.dp, Color.Black),
//        shape = CircleShape
        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(imageVector =Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

    //paddinvalue
    Button(
        onClick = onButton,
        enabled = false,
        border = BorderStroke(10.dp, Color.Black),
//        shape = CircleShape
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(3.dp)
    ) {
        Icon(imageVector =Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

}