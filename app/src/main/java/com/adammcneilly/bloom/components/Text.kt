package com.adammcneilly.bloom.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.adammcneilly.bloom.theme.BloomTheme
import com.adammcneilly.bloom.theme.LocalContentColor

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = BloomTheme.typography.body1,
    color: Color = LocalContentColor.current,
) {
    BasicText(
        text = text,
        style = style.copy(
            color = color,
        ),
        modifier = modifier,
    )
}
