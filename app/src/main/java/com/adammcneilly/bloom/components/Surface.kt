package com.adammcneilly.bloom.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.adammcneilly.bloom.theme.BloomTheme
import com.adammcneilly.bloom.theme.LocalContentColor
import com.adammcneilly.bloom.theme.contentColorFor

/**
 * The main purpose of this [Surface] class is to provide a default [containerColor] for an entire section
 * and ovveride the [LocalContentColor] accordingly.
 */
@Composable
fun Surface(
    modifier: Modifier = Modifier,
    containerColor: Color = BloomTheme.colors.surface,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalContentColor provides BloomTheme.colors.contentColorFor(containerColor),
    ) {
        Box(
            modifier = modifier
                .background(containerColor),
        ) {
            content()
        }
    }
}
