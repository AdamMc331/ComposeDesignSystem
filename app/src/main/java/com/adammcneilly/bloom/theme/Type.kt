package com.adammcneilly.bloom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.adammcneilly.bloom.R

private val NunitoBold = FontFamily(Font(R.font.nunitosans_bold))
private val NunitoSemiBold = FontFamily(Font(R.font.nunitosans_semibold))
private val NunitoLight = FontFamily(Font(R.font.nunitosans_light))

private val h1 = TextStyle(
    fontFamily = NunitoBold,
    fontSize = 18.sp,
    letterSpacing = 0.sp,
)

private val h2 = TextStyle(
    fontFamily = NunitoBold,
    fontSize = 14.sp,
    letterSpacing = 0.15.sp,
)

private val subtitle1 = TextStyle(
    fontFamily = NunitoLight,
    fontSize = 18.sp,
    letterSpacing = 0.sp,
)

private val body1 = TextStyle(
    fontFamily = NunitoLight,
    fontSize = 14.sp,
    letterSpacing = 0.sp,
)

private val body2 = TextStyle(
    fontFamily = NunitoLight,
    fontSize = 12.sp,
    letterSpacing = 0.sp,
)

private val button = TextStyle(
    fontFamily = NunitoSemiBold,
    fontSize = 14.sp,
    letterSpacing = 1.sp,
)

private val caption = TextStyle(
    fontFamily = NunitoSemiBold,
    fontSize = 12.sp,
    letterSpacing = 0.sp,
)

@Immutable
data class BloomTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val subtitle1: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val button: TextStyle,
    val caption: TextStyle,
)

val defaultTypography: BloomTypography = BloomTypography(
    h1 = h1,
    h2 = h2,
    subtitle1 = subtitle1,
    body1 = body1,
    body2 = body2,
    button = button,
    caption = caption,
)
