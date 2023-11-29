package com.example.compose_component_example.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ModifierExample(){
    Button(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

    //fillmaxsize
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

    //height, width
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }
    //size를 통한width, height
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(100.dp,100.dp)

    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

    //color
    Button(
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Magenta,
            containerColor =Color.Cyan
        ),
        onClick = { /*TODO*/ },
        modifier = Modifier.size(100.dp,100.dp)

    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

    //padding
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(100.dp,100.dp).padding(10.dp)

    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text("button")
    }

    //offset

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(100.dp,100.dp).padding(10.dp)

    ) {
        Icon(imageVector = Icons.Filled.Send, contentDescription = null)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            "button",
            modifier = Modifier.offset(x = 10.dp)
        )
    }





}