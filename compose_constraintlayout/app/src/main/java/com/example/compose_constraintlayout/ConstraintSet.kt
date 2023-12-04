package com.example.compose_constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun constraintSet(){
    val constraintSet = ConstraintSet{
        val redBox = createRefFor("redBox")
        val magantaBox = createRefFor("magantaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox){
            bottom.linkTo(parent.bottom)
        }
        constrain(magantaBox){
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }
        constrain(greenBox){
            bottom.linkTo(parent.bottom, 8.dp)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
            top.linkTo(parent.top)

        }
        constrain(yellowBox){
            start.linkTo(redBox.end)
        }

    }
    ConstraintLayout(
        constraintSet,
        modifier = Modifier.fillMaxSize()) {


        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Red)
            .layoutId("redBox")
            )

        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Magenta)
            .layoutId("magantaBox")
            )

        Box(modifier= Modifier
            .size(40.dp)
            .background((Color.Green))
            .layoutId("greenBox")
            )

        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Yellow)
            .layoutId("yellowBox")
            )
    }
}