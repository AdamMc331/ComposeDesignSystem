package com.adammcneilly.bloom

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.bloom.components.OutlinedTextField
import com.adammcneilly.bloom.components.SecondaryButton
import com.adammcneilly.bloom.components.Surface
import com.adammcneilly.bloom.components.Text
import com.adammcneilly.bloom.theme.BloomTheme

@Composable
fun LoginScreen(
    onLoginClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        containerColor = BloomTheme.colors.background,
        modifier = modifier
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Log in with email",
                style = BloomTheme.typography.h1,
                modifier = Modifier
                    .paddingFromBaseline(184.dp),
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )

            OutlinedTextField(
                initialText = "Email address",
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Spacer(
                modifier = Modifier
                    .height(8.dp),
            )

            OutlinedTextField(
                initialText = "Password (8+ Characters)",
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Text(
                text = "By clicking below, you agree to our Terms of Use and consent to our Privacy Policy",
                style = BloomTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .paddingFromBaseline(24.dp),
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp),
            )

            SecondaryButton(
                text = "Log in",
                onClick = onLoginClicked,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
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
private fun LoginScreenPreview() {
    BloomTheme {
        LoginScreen(onLoginClicked = { /*TODO*/ })
    }
}
