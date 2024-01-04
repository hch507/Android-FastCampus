package com.example.compose_movie_information_app.ui.component.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Locale.Category

@Composable
fun Category() {
    Column {
        CategoryTitle("Action")
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = 10.dp
            )
        ) {
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }

        }

    }
}

@Composable
fun CategoryTitle(s: String) {
    Text(
        modifier = Modifier.padding(10.dp),
        text = s
    )
}

@Preview
@Composable
fun CategoryPreview(){
    Category()
}
