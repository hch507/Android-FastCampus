package com.example.compose_movie_information_app.ui.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.compose_movie_information_app.ui.models.DialogTitle
import com.example.compose_movie_information_app.ui.component.dialog.component.button.DialogButtonColumn
import com.example.compose_movie_information_app.ui.component.dialog.component.content.DialogContentWrapper

import com.example.compose_movie_information_app.ui.component.dialog.component.title.DialogTitleWrapper
import com.example.compose_movie_information_app.ui.models.DialogButton
import com.example.compose_movie_information_app.ui.models.DialogContent

import com.example.compose_movie_information_app.ui.theme.color.Padding

@Composable
fun BaseDiaLogPopup(
    dialogTitle : DialogTitle? =null,
    dialogCotent : DialogContent? =null,
    button : List<DialogButton>? = null
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let{
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(
                        start = Padding.xlarge,
                        end = Padding.xlarge,
                        bottom = Padding.xlarge
                    )
            ) {
                dialogCotent?.let{ DialogContentWrapper(it)}
                button?.let{DialogButtonColumn(it)}
            }
        }
    }
}



