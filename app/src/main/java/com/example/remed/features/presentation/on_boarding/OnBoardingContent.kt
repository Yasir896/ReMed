package com.example.remed.features.presentation.on_boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remed.R
import com.example.remed.features.ImageContainerWithContent
import com.example.remed.ui.theme.ReMedTheme

@Composable
fun OnBoardingContent(
    takeToHomeScreen: () -> Unit
) {

    Column(Modifier.fillMaxSize()) {

        ImageWithAppName()

        Spacer(modifier = Modifier.height(24.dp))

        AppMessage()

        Spacer(modifier = Modifier.height(24.dp))

        FloatingActionButton(onClick = takeToHomeScreen)
    }
}

@Composable
fun ImageWithAppName() {
    ImageContainerWithContent(
        modifier = Modifier.aspectRatio(1f, false),
        R.drawable.ornamen_background_image,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .padding(30.dp)
                    .align(Alignment.TopEnd),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "ReMed",
                    color = ReMedTheme.colors.light,
                    style = MaterialTheme.typography.h5
                )

                Text(
                    text = "About",
                    color = ReMedTheme.colors.brand,
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Composable
fun AppMessage() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = ReMedTheme.colors.textPrimary,
            text = "Manage Your Daily \nmedication intake \neasily with ReMed",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = ReMedTheme.colors.textSecondary,
            text = "Simple add, remind, done. \nAll your meds can be organized here",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun FloatingActionButton(onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        androidx.compose.material.FloatingActionButton(
            backgroundColor = ReMedTheme.colors.brand,
            onClick = onClick
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = null,
            )
        }
    }
}