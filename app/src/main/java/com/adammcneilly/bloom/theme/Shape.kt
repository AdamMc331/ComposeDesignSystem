package com.adammcneilly.bloom.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

private val small = RoundedCornerShape(4.dp)
private val medium = RoundedCornerShape(24.dp)

@Immutable
data class BloomShapes(
    val small: Shape,
    val medium: Shape,
)

val defaultShapes: BloomShapes = BloomShapes(
    small = small,
    medium = medium,
)
