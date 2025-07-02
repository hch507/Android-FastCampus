package com.example.part4_compose_movie_app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.example.part4_compose_movie_app.ui.theme.color.ColorSet
import com.example.part4_compose_movie_app.ui.theme.color.MyColors


@Composable
fun Part4_compose_movie_appTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    myColors: ColorSet= ColorSet.Red,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    val colors = if(darkTheme){
        myColors.DarkColors
    }else{
        myColors.LightColors
    }
    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors.material,
            typography = Typography,
            content = content
        )
    }

}
val LocalColors = staticCompositionLocalOf<MyColors> {
    error("No MyColors provided")
}

val MaterialTheme.colorScheme: MyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current