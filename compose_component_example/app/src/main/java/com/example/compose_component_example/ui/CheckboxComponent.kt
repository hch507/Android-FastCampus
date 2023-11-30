package com.example.compose_component_example.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun checkboxExample(){
//    val check = remember { mutableStateOf(false) }
//    Row(
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Checkbox(checked = check.value, onCheckedChange = {
//            check.value=!check.value
//        })
//        Text(text = "프로그래머입니까?")
//    }

    var check by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = check, onCheckedChange = {
            check=!check
        })
        Text(text = "프로그래머입니까?")
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun previewCheckbox(){
//    checkboxExample()
//}
