package com.example.remed.features.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.annotation.ExperimentalCoilApi
import com.example.remed.R
import com.example.remed.ui.theme.ReMedTheme

@ExperimentalCoilApi
@Composable
fun TopAppBarWithNav(
    title: String = "Title",
    color: Color = ReMedTheme.colors.brand,
    navigationClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier,
    showSettingsIcon: Boolean = false,
) {

    val titleIconModifier = Modifier.fillMaxHeight()
        .width(72.dp)

    TopAppBar(
        backgroundColor = color,
        elevation = 0.dp,
        modifier= modifier.fillMaxWidth().zIndex(1f)) {

        //TopAppBar Content
        Box(Modifier.height(40.dp)) {

            //Navigation Icon
                Row(titleIconModifier, verticalAlignment = Alignment.CenterVertically) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.high,
                    ) {
                        IconButton(
                            onClick = navigationClick ,
                            enabled = true,
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_back),
                                contentDescription = "Back",
                                tint = ReMedTheme.colors.uiBackground,
                            )
                        }
                    }
                }

            //Title
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {

                ProvideTextStyle(value = MaterialTheme.typography.h6) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.high,
                    ){
                        Text(
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 80.dp),
                            textAlign = TextAlign.Center,
                            color = ReMedTheme.colors.uiBackground,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            text = title
                        )
                    }
                }
            }

            if (showSettingsIcon) {
                Row(Modifier.align(Alignment.CenterEnd), verticalAlignment = Alignment.CenterVertically) {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        IconButton(
                            modifier = Modifier.padding(top = 8.dp),
                            onClick = { onSettingsClick() },
                            enabled = true,
                        ) {
                            Icon(
                                modifier = modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.ic_settings),
                                contentDescription = "Back",
                                tint = ReMedTheme.colors.uiBackground,
                            )
                        }
                    }
                }
            }

        }
    }
}

@ExperimentalCoilApi
@Preview
@Composable
fun PreviewTopBarWithClose() {
    ReMedTheme() {
        TopAppBarWithNav( "Create a new ReMed",
            navigationClick = { },
            modifier = Modifier, onSettingsClick = { })
    }
}
