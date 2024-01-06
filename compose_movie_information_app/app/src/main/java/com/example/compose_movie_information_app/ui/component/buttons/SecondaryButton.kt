package com.example.compose_movie_information_app.ui.component.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_movie_information_app.ui.theme.color
import com.example.compose_movie_information_app.ui.theme.color.Padding

@Composable
fun SecondaryButton(
    modifier : Modifier = Modifier,
    text : String,
    onClick : () -> Unit
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth(),
        border = BorderStroke(
            2.dp,
            MaterialTheme.color.secondary
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.color.background,
            contentColor = MaterialTheme.color.secondary,
            disabledContainerColor = MaterialTheme.color.background,
            disabledContentColor = MaterialTheme.color.disabledSecondary
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = text, modifier= Modifier.padding(Padding.small))
        }
    }
}