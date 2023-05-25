package com.example.remed.features

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.example.remed.ui.theme.ReMedTheme
import com.example.remed.ui.theme.Typography


private val ButtonShape = RoundedCornerShape(percent = 20)

@Composable
fun ReMedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = ButtonShape,
    border: BorderStroke? = null,
    backgroundGradient: Color = ReMedTheme.colors.textPrimary,
    disabledBackgroundGradient: Color = ReMedTheme.colors.textPrimary,
    contentColor: Color = ReMedTheme.colors.textPrimary,
    disabledContentColor: Color = ReMedTheme.colors.textSecondary,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    ReMedSurface(
        shape = shape,
        color = ReMedTheme.colors.brand,
        contentColor = if (enabled) contentColor else disabledContentColor,
        border = border,
        modifier = modifier
            .clip(shape)
            .background(if (enabled) backgroundGradient else disabledBackgroundGradient)
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = null
            )
            .indication(interactionSource, rememberRipple())
    ) {
        ProvideTextStyle(value = MaterialTheme.typography.button) {
            Row(
                Modifier
                    .defaultMinSize(
                        minWidth = ButtonDefaults.MinWidth,
                        minHeight = ButtonDefaults.MinHeight
                    )
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}