package com.example.compose_component_example.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaffold(){
    var check = remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scaffold") },
                navigationIcon = {
                    Image(imageVector = Icons.Filled.ArrowBack, contentDescription ="" )
                })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                
            }
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {
            checkWithText(check = check.value, onCheck ={
                check.value =!check.value
            } ) {
                Text(text = "텍스트")
            }
        }

    }
}