package com.example.part4_compose_movie_app.ui.component.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.part4_compose_movie_app.ui.theme.Padding
import com.example.part4_compose_movie_app.ui.theme.Part4_compose_movie_appTheme

@Composable
fun CategoryTitle(titleName: String) {
    Text(
        text = titleName,
        modifier = Modifier.padding(
            vertical = Padding.large,
            horizontal = Padding.xlarge)
    )
    Category()
}

@Composable
fun Category(){
    Column {
        CategoryTitle(titleName = "Action")
        LazyRow(
            contentPadding = PaddingValues(horizontal = Padding.large)
        ) {
//            itemIndexed
            item {
                MovieItem()
            }
        }
    }
}
@Preview
@Composable
fun CategoryPreview(){
    Part4_compose_movie_appTheme {
        Category()
    }

}

