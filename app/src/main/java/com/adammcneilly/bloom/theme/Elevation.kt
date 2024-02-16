package com.adammcneilly.bloom.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val card = 1.dp
private val snackbar = 2.dp
private val bottomNavigation = 16.dp

@Immutable
data class BloomElevation(
    val card: Dp,
    val snackbar: Dp,
    val bottomNavigation: Dp,
)

val defaultElevation: BloomElevation = BloomElevation(
    card = card,
    snackbar = snackbar,
    bottomNavigation = bottomNavigation,
)
