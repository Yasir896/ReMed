package com.example.remed.features.components

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.remed.ui.theme.ReMedTheme

@Composable
fun ReMedDivider(
    modifier: Modifier = Modifier,
    color: Color = ReMedTheme.colors.brand,
    thickness: Dp = 1.dp,
    startIndent: Dp = 0.dp) {

    Divider(
        modifier = modifier,
        color = color,
        thickness = thickness,
        startIndent = startIndent
    )
}

private const val DividerAlpha = 0.12f