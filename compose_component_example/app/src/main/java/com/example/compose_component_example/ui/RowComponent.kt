package com.example.compose_component_example.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun rowExample(){
    Row(
        modifier = Modifier.height(40.dp)
    ){
        Text("첫번째")
        Text("두번째")
        Text("세번째")
    }

    //align
    Row(
        modifier = Modifier.height(40.dp)
    ){
        Text("첫번째", modifier = Modifier.align(CenterVertically))
        Text("두번째",modifier = Modifier.align(Top))
        Text("세번째",modifier = Modifier.align(Bottom))
    }

    //verticalAlignment

    Row(
        verticalAlignment=Alignment.Top,
        modifier = Modifier.height(40.dp)
    ){
        Text("첫번째")
        Text("두번째")
        Text("세번째")
    }
    //horizontalArrangement
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment=Alignment.Top,
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)
    ){
        Text("첫번째")
        Text("두번째")
        Text("세번째")
    }
    //weight
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment=Alignment.Top,
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)
    ){
        Text("첫번째", modifier = Modifier.weight(3f))
        Text("두번째",modifier = Modifier.weight(2f))
        Text("세번째",modifier = Modifier.weight(3f))
    }
}