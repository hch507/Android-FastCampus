package com.example.compose_component_example.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ColumnExample(){
    Column(
        modifier = Modifier.size(100.dp)
    ) {
        Text("첫번째")
        Text("두번째")
        Text("세번째")
    }
    //horizontalAlign
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier.size(100.dp)
    ) {
        Text("첫번째")
        Text("두번째")
        Text("세번째")
    }

    //verticalArrangement
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier.size(100.dp)
    ) {
        Text("첫번째")
        Text("두번째")
        Text("세번째")
    }

}