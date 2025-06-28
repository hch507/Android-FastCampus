package com.example.part4_compose_movie_app.ui.component.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part4_compose_movie_app.R
import com.example.part4_compose_movie_app.ui.theme.Padding


private val CARD_WIDTH = 150.dp

@Composable
fun MovieItem() {
    Column(
        modifier = Modifier
            .width(CARD_WIDTH)
            .padding(Padding.large)
    ) {
        Poster(
            modifier = Modifier.width(
                CARD_WIDTH
            )
        )
        Text(
            text = "The Lord the ring",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                top = Padding.large
            )
        )
        Row(
            modifier = Modifier.padding(
                vertical = Padding.large
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(

                modifier = Modifier
                    .padding(Padding.small)
                    .size(12.dp),
                painter = painterResource(id = R.drawable.ic_star_24),
                tint = Color.Black.copy(
                    0.5f
                ),
                contentDescription = "star"
            )
            Text(
                text = "5.0"
            )
        }
    }
}

@Composable
fun Poster(
    modifier: Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier.background(Color.Blue)
        )
    }
}

@Preview
@Composable
fun MovieItemPreview(){
    MovieItem()
}
