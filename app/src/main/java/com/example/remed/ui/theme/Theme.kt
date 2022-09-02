package com.example.remed.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = ReMedColors(
    brand = Medium,
    brandSecondary = Dark,
    uiBackground = White,
    textPrimary = Black,
    textSecondary = Grey,
    light = Lighter
)

/*private val LightColorPalette = ReMedColors(
    brand = Medium,
    brandSecondary = Light,
    uiBackground = Lighter,
    textPrimary = White,
    textSecondary = Grey,
    error = Black
)*/

@Composable
fun ReMedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit) {

    /*val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }*/
    val colors = DarkColorPalette

    ProvideReMedColors(colors = colors) {
        MaterialTheme(
            colors = debugColors(darkTheme, colors),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}

object ReMedTheme {
    val colors: ReMedColors
        @Composable
        get() = localColorProvider.current
}


/**
 ReMed Custom Color Pallet
 */

@Stable
class ReMedColors(
    brand: Color,
    brandSecondary: Color,
    uiBackground: Color,
    textPrimary: Color,
    textSecondary: Color,
    light: Color
) {
    var brand by mutableStateOf(brand)
        private set
    var brandSecondary by mutableStateOf(brandSecondary)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var light by mutableStateOf(light)
        private set


    fun update(other: ReMedColors) {
        brand = other.brand
        brandSecondary = other.brand
        uiBackground = other.uiBackground
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        light = other.light

    }

    fun copy(): ReMedColors = ReMedColors(
        brand = brand,
        brandSecondary = brandSecondary,
        uiBackground = uiBackground,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        light = light
    )
}

@Composable
fun ProvideReMedColors(
    colors: ReMedColors,
    content: @Composable () -> Unit
) {

    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider( localColorProvider provides colorPalette, content = content)
}

private val localColorProvider = staticCompositionLocalOf<ReMedColors> {
    error("ReMedColorPalette not provided")
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [TerraVirtuaTheme.colors].
 */

fun debugColors(
    darkTheme: Boolean,
    debugColor: ReMedColors
) = Colors (
    primary = debugColor.brand,
    primaryVariant = debugColor.brand,
    secondary = debugColor.brandSecondary,
    secondaryVariant = debugColor.brandSecondary,
    background = debugColor.uiBackground,
    surface = debugColor.uiBackground,
    error = debugColor.light,
    onPrimary = debugColor.brand,
    onSecondary = debugColor.textSecondary,
    onBackground = debugColor.uiBackground,
    onSurface = debugColor.uiBackground,
    onError = debugColor.light,
    isLight = !darkTheme
        )