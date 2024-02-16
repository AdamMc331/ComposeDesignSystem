@file:Suppress("MagicNumber")

package com.adammcneilly.bloom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

private val White = Color(0xFFFFFFFF)
private val White150 = White.copy(alpha = 0.15F)
private val White850 = White.copy(alpha = 0.85F)
private val Pink100 = Color(0xFFFFF1F1)
private val Pink900 = Color(0xFF3F2C2C)
private val Gray = Color(0xFF232323)
private val Green300 = Color(0xFFB8C9B8)
private val Green900 = Color(0xFF2D3B2D)

@Immutable
data class BloomColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
)

val lightColors: BloomColors = BloomColors(
    primary = Pink100,
    onPrimary = Gray,
    secondary = Pink900,
    onSecondary = White,
    background = White,
    onBackground = Gray,
    surface = White850,
    onSurface = Gray,
)

val darkColors: BloomColors = BloomColors(
    primary = Green900,
    onPrimary = White,
    secondary = Green300,
    onSecondary = Gray,
    background = Gray,
    onBackground = White,
    surface = White150,
    onSurface = White850,
)
