package com.example.compose_constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose_constraintlayout.ui.theme.Compose_constraintlayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_constraintlayoutTheme {
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

@Composable
fun constraintEx() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, magantaBox , greenBox, yellowBox) = createRefs()

        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Red)
            .constrainAs(redBox){
                bottom.linkTo(parent.bottom)
            })

        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Magenta)
            .constrainAs(magantaBox){
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            })

        Box(modifier= Modifier
            .size(40.dp)
            .background((Color.Green))
            .constrainAs(greenBox){
                bottom.linkTo(parent.bottom, 8.dp)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                top.linkTo(parent.top)

            })

        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox){
                start.linkTo(redBox.end)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_constraintlayoutTheme {
       constraintEx()
    }
}