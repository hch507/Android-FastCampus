package com.example.compose_component_example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_component_example.ui.buttonExample
import com.example.compose_component_example.ui.textExample
import com.example.compose_component_example.ui.theme.Compose_component_exampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_component_exampleTheme {
                buttonExample {
                    Toast.makeText(this,"send message",Toast.LENGTH_SHORT).show()
                }
                // A surface container using the 'background' color from the theme
            // textExample(text = "compose")

            }
        }
    }
}

