package com.example.remed.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ImageContainerWithContent(
    modifier: Modifier,
    imageId: Int = 0,
    content: @Composable () -> Unit
) {
    ReMedSurface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large

    ) {
        if (imageId != 0) {
            Image(
                painterResource(id = imageId),
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                modifier = Modifier.fillMaxSize())
        }
        content()
    }
}