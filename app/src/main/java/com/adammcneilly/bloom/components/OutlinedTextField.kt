package com.adammcneilly.bloom.components

import android.content.res.Configuration
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adammcneilly.bloom.theme.BloomTheme
import com.adammcneilly.bloom.theme.LocalContentColor

data class OutlinedTextFieldColors(
    val borderColor: Color,
    val hintTextColor: Color,
    val inputTextColor: Color,
)

@Composable
fun defaultOutlinedTextFieldColors(): OutlinedTextFieldColors {
    return OutlinedTextFieldColors(
        borderColor = BloomTheme.colors.onBackground,
        hintTextColor = LocalContentColor.current.copy(alpha = 0.13F),
        inputTextColor = LocalContentColor.current,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OutlinedTextField(
    initialText: String,
    modifier: Modifier = Modifier,
    colors: OutlinedTextFieldColors = defaultOutlinedTextFieldColors(),
    shape: Shape = BloomTheme.shapes.small,
    style: TextStyle = BloomTheme.typography.body1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val textFieldState = rememberTextFieldState(
        initialText = initialText,
    )

    val isFocusedState by interactionSource.collectIsFocusedAsState()

    val targetBorderWidth = when {
        isFocusedState -> 1.dp
        else -> Dp.Hairline
    }

    val borderWidth = animateDpAsState(targetValue = targetBorderWidth, label = "")

    Box(
        modifier = modifier
            .border(
                width = borderWidth.value,
                color = colors.borderColor,
                shape = shape,
            )
            .heightIn(56.dp),
    ) {
        BasicTextField2(
            state = textFieldState,
            textStyle = style.copy(
                color = colors.inputTextColor,
            ),
            interactionSource = interactionSource,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterStart),
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
private fun EmptyOutlinedTextFieldPreview() {
    BloomTheme {
        OutlinedTextField(
            initialText = "",
            modifier = Modifier
                .padding(8.dp),
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
private fun FilledOutlinedTextFieldPreview() {
    BloomTheme {
        OutlinedTextField(
            initialText = "Testing",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        )
    }
}
