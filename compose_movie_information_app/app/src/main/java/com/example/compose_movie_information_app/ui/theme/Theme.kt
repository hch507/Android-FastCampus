package com.example.compose_movie_information_app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.compose_movie_information_app.ui.theme.color.ColorSet
import com.example.compose_movie_information_app.ui.theme.color.MyColors
import com.example.compose_movie_information_app.ui.theme.color.Pink40
import com.example.compose_movie_information_app.ui.theme.color.Pink80
import com.example.compose_movie_information_app.ui.theme.color.Purple40
import com.example.compose_movie_information_app.ui.theme.color.Purple80
import com.example.compose_movie_information_app.ui.theme.color.PurpleGrey40
import com.example.compose_movie_information_app.ui.theme.color.PurpleGrey80


private val LocalColors = staticCompositionLocalOf { ColorSet.Red.LightColors }
@Composable
fun Compose_movie_information_appTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    colors : ColorSet =ColorSet.Red,
    content: @Composable () -> Unit
) {

    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> colors.DarkColors
        else -> colors.LightColors
    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }
    CompositionLocalProvider(LocalColors provides colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme.material,
            typography = Typography,
            shapes = Shape,
            content = content
        )
    }

}

val MaterialTheme.color :MyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current