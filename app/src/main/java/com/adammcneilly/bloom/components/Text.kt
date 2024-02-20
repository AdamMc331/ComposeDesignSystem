package com.adammcneilly.bloom.components

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.adammcneilly.bloom.theme.BloomTheme
import com.adammcneilly.bloom.theme.LocalContentColor

@Composable
fun Text(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = BloomTheme.typography.body1,
    color: Color = LocalContentColor.current,
    textAlign: TextAlign = TextAlign.Unspecified,
) {
    BasicText(
        text = text,
        style = style.copy(
            color = color,
            textAlign = textAlign,
        ),
        modifier = modifier,
    )
}
