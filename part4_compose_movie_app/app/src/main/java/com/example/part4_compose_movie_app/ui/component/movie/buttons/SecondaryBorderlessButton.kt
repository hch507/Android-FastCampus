package com.example.part4_compose_movie_app.ui.component.movie.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.example.part4_compose_movie_app.ui.theme.Padding
import com.example.part4_compose_movie_app.ui.theme.Part4_compose_movie_appTheme
import com.example.part4_compose_movie_app.ui.theme.colorScheme

@Composable
fun SecondaryBorderlessButton(
    modifier: Modifier = Modifier,
    @StringRes id :  Int? =null,
    text: String ="",
    onClick :() ->Unit
){
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorScheme.background ,
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContentColor = MaterialTheme.colorScheme.background,
            disabledBackgroundColor = MaterialTheme.colorScheme.disabledSecondary
        )
    ) {
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(
                text=id?.let{ stringResource(id=id) } ?: text,
                modifier= Modifier.padding(Padding.small),
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colorScheme.secondary
            )
        }

    }

}
