package com.example.compose_profilecard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.compose_profilecard.MainActivity.Companion.cardData
import com.example.compose_profilecard.ui.theme.Compose_profilecardTheme

@Composable
fun constraintCardEx() {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            val (profileImage, author, description) = createRefs()
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = "이미지",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .constrainAs(profileImage) {
                        start.linkTo(parent.start, margin = 8.dp)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(parent.top)
                    }

            )
            Text(
                text = cardData.author,
                modifier = Modifier
                    .constrainAs(author){
                        linkTo(
                            profileImage.end,parent.end,
                            startMargin = 8.dp)
                        width= Dimension.fillToConstraints
                    }

            )
            Text(
                text = cardData.description,
                modifier = Modifier
                    .constrainAs(description){
                        linkTo(
                            profileImage.end,parent.end,
                            startMargin = 8.dp,
                            endMargin = 8.dp
                        )
                        width= Dimension.fillToConstraints
                }
            )
            createVerticalChain(author,description , chainStyle = ChainStyle.Packed)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun cardPreView() {
    Compose_profilecardTheme {
        constraintCardEx()
    }
}
