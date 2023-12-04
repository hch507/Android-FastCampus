package com.example.compose_constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ChainOrBarrierEx(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (redBox, magantaBox , greenBox, text) = createRefs()


        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Red)
            .constrainAs(redBox) {
                top.linkTo(parent.top, 16.dp)
            })

        Box(modifier= Modifier
            .size(40.dp)
            .background(Color.Magenta)
            .constrainAs(magantaBox) {
                top.linkTo(parent.top, 32.dp)
            })

        Box(modifier= Modifier
            .size(40.dp)
            .background((Color.Green))
            .constrainAs(greenBox) {
                top.linkTo(parent.top, 16.dp)
            })

//        Box(modifier= Modifier
//            .size(40.dp)
//            .background(Color.Yellow)
//            .constrainAs(yellowBox){
//            })

        createHorizontalChain(redBox, magantaBox, greenBox)

        val barrier =createBottomBarrier(redBox, magantaBox, greenBox)
        
        Text(
            text = "안녕하세요",
            modifier= Modifier.constrainAs(text){
                top.linkTo(barrier)
            })

    }
}