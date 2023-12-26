package com.example.compose_todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_todo.ui.theme.Compose_todoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_todoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun todoInput(
    text : String,
    onTextChange :(String) -> Unit,
    onClick : (String) -> Unit
){
    Row {
       OutlinedTextField(
           modifier =Modifier.weight(1f),
           value = text ,
           onValueChange = onTextChange )
        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = { onClick }
        ) {
            Text(text = "등록하기")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Compose_todoTheme {
        todoInput(text ="청소하기" , onTextChange = {}, onClick = {})
    }
}