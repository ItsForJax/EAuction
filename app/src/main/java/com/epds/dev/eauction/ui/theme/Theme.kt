package com.epds.dev.eauction.ui.theme

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle


@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        localAppColors provides extendedColors,
        localAppTypography provides extendedTypography
    ) {
        MaterialTheme(
        content = content
        )
    }

}

object AppTheme {
    val colors: AppColors
    @Composable
    get() = localAppColors.current

    val typography: AppTypography
    @Composable
    get() = localAppTypography.current
}