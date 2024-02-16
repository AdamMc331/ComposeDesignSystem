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
import com.adammcneilly.bloom.theme.contentColorFor

data class SecondaryButtonColors(
    val containerColor: Color,
    val contentColor: Color,
)

@Composable
fun defaultSecondaryButtonColors(
    containerColor: Color = BloomTheme.colors.secondary,
    contentColor: Color = BloomTheme.colors.contentColorFor(containerColor),
): SecondaryButtonColors {
    return SecondaryButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
    )
}

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: SecondaryButtonColors = defaultSecondaryButtonColors(),
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
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun SecondaryButtonPreview() {
    BloomTheme {
        SecondaryButton(
            text = "Primary Button",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
