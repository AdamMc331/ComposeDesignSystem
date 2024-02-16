package com.adammcneilly.bloom.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

val LocalColors = staticCompositionLocalOf {
    BloomColors(
        primary = Color.Unspecified,
        onPrimary = Color.Unspecified,
        secondary = Color.Unspecified,
        onSecondary = Color.Unspecified,
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        surface = Color.Unspecified,
        onSurface = Color.Unspecified,
    )
}

val LocalElevation = staticCompositionLocalOf {
    BloomElevation(
        card = 0.dp,
        snackbar = 0.dp,
        bottomNavigation = 0.dp,
    )
}

val LocalShapes = staticCompositionLocalOf {
    BloomShapes(
        small = RectangleShape,
        medium = RectangleShape,
    )
}

val LocalTypography = staticCompositionLocalOf {
    BloomTypography(
        h1 = TextStyle.Default,
        h2 = TextStyle.Default,
        subtitle1 = TextStyle.Default,
        body1 = TextStyle.Default,
        body2 = TextStyle.Default,
        button = TextStyle.Default,
        caption = TextStyle.Default,
    )
}

val LocalContentColor = staticCompositionLocalOf {
    Color.Unspecified
}

@Composable
fun BloomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        darkColors
    } else {
        lightColors
    }

    val elevation = defaultElevation

    val shapes = defaultShapes

    val typography = defaultTypography

    val defaultContentColor = colors.onBackground

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalElevation provides elevation,
        LocalShapes provides shapes,
        LocalTypography provides typography,
        LocalContentColor provides defaultContentColor,
        content = content,
    )
}

object BloomTheme {
    val colors: BloomColors
        @Composable
        get() = LocalColors.current

    val typography: BloomTypography
        @Composable
        get() = LocalTypography.current

    val elevation: BloomElevation
        @Composable
        get() = LocalElevation.current

    val shapes: BloomShapes
        @Composable
        get() = LocalShapes.current
}
