package com.example.compose_movie_information_app.ui.component.buttons

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
import com.example.compose_movie_information_app.ui.theme.color
import com.example.compose_movie_information_app.ui.theme.color.Padding

@Composable
fun UnderLinedTextButton(
    modifier : Modifier = Modifier,
    text : String,
    onClick : () -> Unit
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.color.primary,
            contentColor = MaterialTheme.color.onPrimary,
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