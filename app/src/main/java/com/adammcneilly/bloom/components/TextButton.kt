package com.adammcneilly.bloom.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.bloom.theme.BloomTheme
import com.adammcneilly.bloom.theme.LocalContentColor

data class TextButtonColors(
    val containerColor: Color,
    val contentColor: Color,
)

@Composable
fun defaultTextButtonColors(
    containerColor: Color = Color.Transparent,
    contentColor: Color = LocalContentColor.current,
): TextButtonColors {
    return TextButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )
}

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: TextButtonColors = defaultTextButtonColors(),
    shape: Shape = BloomTheme.shapes.medium,
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
            )
            .background(
                color = colors.containerColor,
                shape = shape,
            )
            .defaultMinSize(
                minHeight = 48.dp,
            ),
    ) {
        Text(
            text = text,
            style = BloomTheme.typography.button,
            color = colors.contentColor,
            modifier = Modifier
                .align(Alignment.Center),
        )
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF000000,
)
@Composable
private fun TextButtonPreview() {
    BloomTheme {
        TextButton(
            text = "Primary Button",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
