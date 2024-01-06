package com.example.compose_movie_information_app.ui.component.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_movie_information_app.R
import com.example.compose_movie_information_app.ui.theme.color.MyColors
import com.example.compose_movie_information_app.ui.theme.color.Padding


private val CARD_WIDTH = 150.dp
private val ICON_SIZE = 12.dp

@Composable
fun MovieItem() {
    Column(
        modifier = Modifier
            .padding(Padding.large)
            .width(CARD_WIDTH)
    ) {

        Poster(
            Modifier.width(CARD_WIDTH)
        )
        Text(
            modifier = Modifier.padding(
                top = Padding.large
            ),
            text = "The load the ring1",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.padding(vertical = Padding.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(Padding.small)
                    .size(ICON_SIZE),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_rating),
                contentDescription = "rating",
                tint = Color.Black.copy(
                    alpha=0.5f
                )
            )
            Text(
                text = "5.0",
                color = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = 0.5f
                ))
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

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    MovieItem()
}


