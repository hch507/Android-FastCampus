package com.example.compose_component_example.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun checkWithText(
    check : Boolean,
    onCheck : (Boolean) -> Unit,
    content : @Composable RowScope.() -> Unit
){
    Row() {
        Checkbox(checked = check, onCheckedChange = onCheck )
        content()
    }
}
@Composable
fun slotEx(){

    var check1 = remember {
        mutableStateOf(false)
    }
    var check2 = remember {
        mutableStateOf(false)
    }
    checkWithText(
        check = check1.value,
        onCheck ={
            check1.value = !check1.value
        }
    ) {
        Text(text = "텍스트 1")
    }
    checkWithText(
        check = check2.value,
        onCheck ={
            check2.value = !check2.value
        }
    ) {
        Text(text = "텍스트 2")
    }
    


}