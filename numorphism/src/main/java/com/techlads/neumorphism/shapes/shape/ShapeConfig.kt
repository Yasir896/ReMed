package com.techlads.neumorphism.shapes.shape

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.techlads.neumorphism.shapes.NeuInsets

data class ShapeConfig(
    val neuInsets: NeuInsets,
    val elevation: Dp,
    val lightShadowColor: Color,
    val darkShadowColor: Color,
    val strokeWidth: Dp,
    var cornerType: CornerType = CornerType.Rounded()
)

sealed class CornerType {
    object Oval: CornerType()
    data class Rounded(val radius: Dp = 12.dp) : CornerType()
}