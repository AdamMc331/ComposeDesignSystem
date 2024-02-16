package com.adammcneilly.bloom

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.bloom.components.SecondaryButton
import com.adammcneilly.bloom.components.Text
import com.adammcneilly.bloom.components.TextButton
import com.adammcneilly.bloom.theme.BloomTheme
import com.adammcneilly.bloom.theme.LocalContentColor
import com.adammcneilly.bloom.theme.contentColorFor

@Composable
@Suppress("LongMethod")
fun WelcomeScreen(
    onLoginClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val containerColor = BloomTheme.colors.primary

    Box(
        modifier = modifier
            .background(
                color = containerColor,
            )
            .fillMaxSize(),
    ) {
        CompositionLocalProvider(
            LocalContentColor provides BloomTheme.colors.contentColorFor(containerColor),
        ) {
            BackgroundImage()

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Spacer(
                    modifier = Modifier
                        .height(72.dp),
                )

                WelcomeImage()

                Spacer(
                    modifier = Modifier
                        .height(48.dp),
                )

                val logoRes = if (isSystemInDarkTheme()) {
                    R.drawable.ic_dark_logo
                } else {
                    R.drawable.ic_light_logo
                }
                Image(
                    painterResource(id = logoRes),
                    contentDescription = "Bloom Logo",
                )

                Text(
                    text = "Beautiful home garden solutions",
                    style = BloomTheme.typography.subtitle1,
                    modifier = Modifier
                        .paddingFromBaseline(32.dp),
                )

                Spacer(
                    modifier = Modifier
                        .height(40.dp),
                )

                SecondaryButton(
                    text = "Create account",
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(),
                )

                Spacer(
                    modifier = Modifier
                        .height(8.dp),
                )

                TextButton(
                    text = "Log in",
                    onClick = onLoginClicked,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
private fun WelcomeImage() {
    val imageRes = if (isSystemInDarkTheme()) {
        R.drawable.ic_dark_welcome_illos
    } else {
        R.drawable.ic_light_welcome_illos
    }

    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "Welcome Image",
        modifier = Modifier
            .offset(x = 88.dp),
    )
}

@Composable
private fun BackgroundImage() {
    val backgroundImageRes = if (isSystemInDarkTheme()) {
        R.drawable.ic_dark_welcome_bg
    } else {
        R.drawable.ic_light_welcome_bg
    }

    Image(
        painterResource(id = backgroundImageRes),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize(),
    )
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
private fun WelcomeScreenPreview() {
    BloomTheme {
        WelcomeScreen(onLoginClicked = { /*TODO*/ })
    }
}
