package com.epds.dev.eauction.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import com.epds.dev.eauction.R
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

private val interFontFamily = FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.inter_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
)

@Immutable
data class AppTypography(
    val headingXXL: TextStyle,
    val headingXS: TextStyle,
    val headingSmall: TextStyle,
    val bodySmall: TextStyle,
    val bodyExtraSmall: TextStyle,
    val bodyMedium: TextStyle,
    val span14px: TextStyle,
    val buttonLarge: TextStyle,
    val semiBold: TextStyle
)

val localAppTypography = staticCompositionLocalOf {
    AppTypography(
        headingXXL = TextStyle.Default,
        headingXS = TextStyle.Default,
        headingSmall = TextStyle.Default,
        bodySmall = TextStyle.Default,
        bodyExtraSmall = TextStyle.Default,
        bodyMedium = TextStyle.Default,
        span14px = TextStyle.Default,
        buttonLarge = TextStyle.Default,
        semiBold = TextStyle.Default
    )
}

val extendedTypography = AppTypography(
    headingXXL = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp,
        lineHeight = 67.sp,
        letterSpacing = 0.01.em
    ),

    headingXS = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 28.sp
    ),

    headingSmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 33.sp
    ),

    bodySmall = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),

    bodyExtraSmall = TextStyle(),

    bodyMedium = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.01).em,
    ),

    span14px = TextStyle(),

    buttonLarge = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.01).em
    ),

    semiBold = TextStyle(
        fontFamily = interFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.01).em
    )
)