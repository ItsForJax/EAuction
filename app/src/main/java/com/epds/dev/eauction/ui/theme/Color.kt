package com.epds.dev.eauction.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val White = Color.White
val Base300 = Color(0xFFE2E7F0)
val Base400 = Color(0xFFCBD2E0)
val Base500 = Color(0xFFA0ABC0)
val Base600 = Color(0xFF717D96)
val Base700 = Color(0xFF4A5468)
val Base800 = Color(0xFF2D3648)
val Base900 = Color(0xFF1A202C)

@Immutable
data class AppColors(
    val white: Color,
    val base300: Color,
    val base400: Color,
    val base500: Color,
    val base600: Color,
    val base700: Color,
    val base800: Color,
    val base900: Color
)

val localAppColors = staticCompositionLocalOf {
    AppColors(
        white = Color.Unspecified,
        base300 = Color.Unspecified,
        base400 = Color.Unspecified,
        base500 = Color.Unspecified,
        base600 = Color.Unspecified,
        base700 = Color.Unspecified,
        base800 = Color.Unspecified,
        base900 = Color.Unspecified,
    )
}

val extendedColors = AppColors(
    white = White,
    base300 = Base300,
    base400 = Base400,
    base500 = Base500,
    base600 = Base600,
    base700 = Base700,
    base800 = Base800,
    base900 = Base900,
)